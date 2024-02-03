import java.io.*;
import java.util.ArrayList;

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    // Add a student to the system
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student from the system
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
		if(students.isEmpty()) {
			System.out.println("No data found.");
		} else {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

    // Save student data to a file
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Student data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	// Load student data from a file
	public void loadFromFile(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			ArrayList<Student> loadedStudents = (ArrayList<Student>) ois.readObject();
			students.addAll(loadedStudents);
			System.out.println("Student data loaded from " + fileName);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}