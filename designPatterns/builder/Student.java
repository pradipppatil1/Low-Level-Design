public class Student {
    private String name;
    private int age;
    private String batch;
    private String address;
    private int psp;
    private int gradeYear;

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.batch = builder.batch;
        this.address = builder.address;
        this.psp = builder.psp;
        this.gradeYear = builder.gradeYear;
    }

    public static StudentBuilder StudentBuilder() {
        return new StudentBuilder();
    }
    
// Internal class StudentBuilder
    
    public static class StudentBuilder {

        private String name;
        private int age;
        private String batch;
        private String address;
        private int psp;
        private int gradeYear;

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public int getPsp() {
            return psp;
        }

        public StudentBuilder setPsp(int psp) {
            this.psp = psp;
            return this;
        }

        public int getGradeYear() {
            return gradeYear;
        }

        public StudentBuilder setGradeYear(int gradeYear) {
            this.gradeYear = gradeYear;
            return this;
        }

       /**
         * Builds a new Student object after validating all required fields.
         * 
         * @throws IllegalStateException if any of the following conditions are met:
         *         - name is null
         *         - age is less than or equal to 0
         *         - batch is null
         *         - address is null
         *         - psp (Percentage Success Parameter) is less than 0
         *         - gradeYear is less than 2019
         * 
         * @return a new validated Student instance with all the set properties
        */
        public Student build() {
            //validation starts
            if(name == null || age <= 0 || batch == null || address == null || psp < 0 || gradeYear < 2019) {
                throw new IllegalStateException("Invalid student data");
            }

            //validation ends

            return new Student(this);
        }
    }
}