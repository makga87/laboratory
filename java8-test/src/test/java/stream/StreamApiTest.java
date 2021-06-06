package stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamApiTest {

    @Test
    public void 리스트_문자열_인트형으로_변환() {

        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> integerList = stringList.stream()
                .map(data -> {
                    return Integer.parseInt(data);
                })
                .peek(data -> System.out.println(data.getClass().getName() + " : " + data))
                .collect(Collectors.toList());

    }

    @Test
    public void 리스트_필터링() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        integerList.stream()
                .peek(data -> System.out.println("인입된 데이터 : " + data))
                .filter(data -> data % 2 == 0)
                .peek(data -> System.out.println("출력된 데이터 : " + data))
                .collect(Collectors.toList());
    }

    @Test
    public void 리스트_DISTINCT() {

        List<String> stringList = Arrays.asList("A", "a", "B", "B", "C", "C", "c");

        System.out.println("== DISTINCT ==");

        stringList.stream()
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("== TO_UPPERCASE DISTINCT ==");

        stringList.stream()
                .map(data -> data.toUpperCase())
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    @Test
    public void 리스트_GROUP_BY() {

        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        Map<String, List<Employee>> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupByDept.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    @Test
    public void 리스트_VO로_변환() {

        List<String> nameList = Arrays.asList("김코드", "박개발", "경영만", "최경영");

        List<Employee> employeeList = nameList.stream()
                .map(name -> {
                    Employee employee = new Employee();
                    employee.setName(name);
                    return employee;
                })
                .collect(Collectors.toList());

        employeeList.forEach(e -> {
            System.out.println(e.getName());
        });

    }

    @Test
    public void 리스트_COLLECTORS_TO_MAP_변환() {

        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        // Collectors.toMap의 마지막 인자는 중복키 처리
        Map<String, Employee> deptMap = employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (key1, key2) -> key1));

        deptMap.forEach((key, value) -> {

            StringBuilder sb = new StringBuilder();
            sb.append(key).append(" : ")
                    .append(value.getDepartment()).append(", ")
                    .append(value.getName()).append(", ")
                    .append(value.getAge()).append("\n");

            System.out.print(sb.toString());
        });
    }

    @Test
    public void 리스트_COUNT() {
        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        long count = employees.stream()
                .filter(emp -> emp.getDepartment().startsWith("기술"))
                .count();

        System.out.println(count);
    }

    @Test
    public void 병렬스트림_스트림_로그_비교() {
        List<Employee> employees = Arrays.asList(
                new Employee("개발팀", "김코드", 35),
                new Employee("개발팀", "박개발", 19),
                new Employee("경영팀", "경영만", 40),
                new Employee("경영팀", "최경영", 25),
                new Employee("기술지원팀", "오기술", 43),
                new Employee("기술지원팀", "기술진", 27)
        );

        employees
                .stream()
                .peek(employee ->
                        System.out.println(Thread.currentThread().getName() + " -> stream : " + employee.getName()))
                .collect(Collectors.toList());

        employees
                .parallelStream()
                .peek(employee ->
                        System.out.println(Thread.currentThread().getName() + " -> parallelStream : " + employee.getName()))
                .collect(Collectors.toList());

    }

    @Test
    public void 배열_STREAM_MATCH() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // 전부 일치해야함
        boolean allMatchResult = Arrays.stream(arr).allMatch(num -> num % 2 == 0);

        // 하나라도 일치해야 함
        boolean anyMatchResult = Arrays.stream(arr).anyMatch(num -> num % 2 == 0);

        // 전부 일치하면 안됨.
        boolean noneMatchResult = Arrays.stream(arr).noneMatch(num -> num % 2 == 0);

        System.out.println(allMatchResult);
        System.out.println(anyMatchResult);
        System.out.println(noneMatchResult);
    }

    @Test
    void REDUCTION_숫자_합() {

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum = numbers.reduce((x, y) -> x + y);
        sum.ifPresent(s -> System.out.println(s));

    }

    @Test
    void 문자배열_스트림_변환() {
        "abcdefg".chars()
                .forEach(ch -> {
                    System.out.println(ch);
                    System.out.println((char) ch);
                });
    }

    @Test
    void peek_forEach_차이() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        /*
        peek 중간 처리 메서드로, 최종 처리 메서드를 만나기 전엔 연산을 진행하지 않는다.
         */
        Arrays.stream(arr)
                .peek(num -> System.out.println("최종처리 없음 (peek) : " + num));

        /*
        중간 처리 메서드들은 최종 처리 메서드를 만나야 비로소 정상 동작한다.
         */
        Arrays.stream(arr)
                .peek(num -> System.out.println("최종처리 존재 (peek) : " + num))
                .sum();

        /*
        forEach는 최종처리(Terminal)메서드로 이 후, 특정 메서드를 호출하지 않아도
        정상동작 한다.
         */
        Arrays.stream(arr)
                .forEach(num -> System.out.println("자체가 최종처리 (forEach) : " + num));
    }

    @Test
    void 스트림으로_파일읽기() throws IOException {

        Path path = Paths.get("src/test/resources/stream_test.txt");
        Stream<String> stringStream = Files.lines(path);
        stringStream.forEach(line -> {
            System.out.println(line);
        });

    }

    @Test
    void FLATMAP_TEST() {
        String[][] temp = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
        };

        Arrays.stream(temp)
                .filter(data -> !"a".equals(data[0]) || !"a".equals(data[1]))
                .forEach(data -> System.out.println("{" + data[0] + ", " + data[1] + "}"));

        Arrays.stream(temp)
                .flatMap(data -> Arrays.stream(data))
                .filter(data -> !"a".equals(data))
                .forEach(data -> System.out.println(data));
    }

}