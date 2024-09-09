package list;

import java.util.AbstractList;
import java.util.List;

public class CustomList<E> extends AbstractList<E> {

    private CustomList(){
    }

    public static List getInstance(){
        return new CustomList();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("지원 안함");
    }

    @Override
    public int size() {
        return 0;
    }
}
