package hashcode;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

public class HashCodeTest {

    @DisplayName("객체 내의 리스트의 해시코드 테스트")
    @Test
    void hascodeTest() {

        Man man1 = new Man("kevin");
        Student student1 = new Student(1, "a", man1);
        Man man2 = new Man("peter");
        Student student2 = new Student(2, "b", man2);
        Man man3 = new Man("john");
        Student student3 = new Student(3, "c", man3);

        Classmate classmate = new Classmate();
        classmate.getStudents().add(student1);
        classmate.getStudents().add(student2);
        classmate.getStudents().add(student3);


        int hashcode1 = classmate.hashCode();
        System.out.println("classmate hashcode1 : " + hashcode1);

        /**
         * 정보가 바뀌면 해시코드도 바뀐다.
         */
        student3.setNo(4);
        int hashcode2 = classmate.hashCode();
        System.out.println("classmate hashcode2 : " + hashcode2);

        student3.setNickname("d");
        int hashcode3 = classmate.hashCode();
        System.out.println("classmate hashcode3 : " + hashcode3);

        student3.getMan().setName("luke");
        int hashcode4 = classmate.hashCode();
        System.out.println("classmate hashcode4 : " + hashcode4);


        /**
         * 내부 정보가 같더라도, 새로운 객체면 해시코드가 달라진다.
         */
        Man _man1 = new Man("kevin");
        Student _student1 = new Student(1, "a", _man1);
        Man _man2 = new Man("peter");
        Student _student2 = new Student(2, "b", _man2);
        Man _man3 = new Man("john");
        Student _student3 = new Student(3, "c", _man3);

        Classmate _classmate = new Classmate();
        _classmate.getStudents().add(_student1);
        _classmate.getStudents().add(_student2);
        _classmate.getStudents().add(_student3);

        int hashcode5 = _classmate.hashCode();
        System.out.println("classmate hashcode5 : " + hashcode5);

    }

    @Test
    void objectsHash() {

        Man man1 = new Man("kevin");
        Student student1 = new Student(1, "a", man1);
        Man man2 = new Man("peter");
        Student student2 = new Student(2, "b", man2);
        Man man3 = new Man("john");
        Student student3 = new Student(3, "c", man3);

        Classmate classmate = new Classmate();
        classmate.getStudents().add(student1);
        classmate.getStudents().add(student2);
        classmate.getStudents().add(student3);

        System.out.println("classmate Objects.hash1 : " + Objects.hash(classmate));

        Man _man1 = new Man("kevin");
        Student _student1 = new Student(1, "a", _man1);
        Man _man2 = new Man("peter");
        Student _student2 = new Student(2, "b", _man2);
        Man _man3 = new Man("john");
        Student _student3 = new Student(3, "c", _man3);

        Classmate _classmate = new Classmate();
        _classmate.getStudents().add(_student1);
        _classmate.getStudents().add(_student2);
        _classmate.getStudents().add(_student3);

        System.out.println("classmate Objects.hash2 : " + Objects.hash(_classmate));
    }

    @Data
    public class Classmate {
        private ArrayList<Student> students = new ArrayList<>();
    }

    @Data
    public class Student {
        private int no;
        private String nickname;
        private Man man;

        public Student(int no, String nickname, Man man) {
            this.no = no;
            this.nickname = nickname;
            this.man = man;
        }
    }

    @Data
    public class Man {
        private String name;

        public Man(String name) {
            this.name = name;
        }
    }
}
