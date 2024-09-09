package list;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CustomListTest {


    @DisplayName("CustomList 객체의 이름으로 잘 나오는지 확인한다.")
    @Test
    void test1() {
        List list = CustomList.getInstance();
        System.out.println(list.getClass().getSimpleName());
        System.out.println(list.getClass().getTypeName());
        System.out.println(list.getClass().getCanonicalName());
    }

    @DisplayName("문자열을 변환하여 Object로 반환 했을 때, 동작을 살펴본다.")
    @Test
    void test2() throws JsonProcessingException {

        List<String> arrayList = new ArrayList<String>();
        String arrayListString = listToString(arrayList);
        Object arrayListObj = stringToList(arrayListString);

        System.out.println(arrayListObj);
        System.out.println((List) arrayListObj);
        System.out.println(arrayListObj instanceof List);
        System.out.println((List) arrayListObj instanceof List);
        System.out.println((List) arrayListObj instanceof ArrayList);
        System.out.println((ArrayList) arrayListObj instanceof ArrayList);
        System.out.println("==========================================");

        List emptyList = CustomList.getInstance();
        String emptyListString = listToString(emptyList);
        Object emptyListObj = stringToList(emptyListString);
        System.out.println(emptyListObj);
        System.out.println((List) emptyListObj);
        System.out.println(emptyListObj instanceof List);
        System.out.println((List) emptyListObj instanceof List);
        System.out.println((List) emptyListObj instanceof CustomList);
        System.out.println((CustomList) emptyListObj instanceof CustomList);


    }

    public String listToString(List list) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        return writer.writeValueAsString(list);
    }

    public Object stringToList(String list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

       return mapper.readValue(list, new TypeReference<List>() {});
    }

}