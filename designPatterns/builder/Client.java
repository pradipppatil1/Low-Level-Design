public class Client {

    public static void main(String[] args) {
        // Student.StudentBuilder studentBuilder = Student.getStudentBuilder();
        // studentBuilder.setName("John Doe");
        // studentBuilder.setAge(20);
        // studentBuilder.setBatch("2023");
        // studentBuilder.setAddress("123 Main St");
        // studentBuilder.setPsp(85);
        // studentBuilder.setGradeYear(2020);
        
        // Student student = studentBuilder.build();

        Student student = Student.StudentBuilder()
                        .setName("Pradip")
                        .setAge(25)
                        .setAddress("123 Main St")
                        .setBatch("2023")
                        .setPsp(99)
                        .setGradeYear(2020)
                        .build();

        System.out.println("DEBUG1234");
    }
}