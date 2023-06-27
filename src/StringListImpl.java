import exception.InvalidIndexException;
import exception.ItemNotFoundException;
import exception.NullItemException;


public class StringListImpl implements StringList {
    private String[] storage;
    private int size;


    public StringListImpl(int initialCapacity) {
        storage = new String[initialCapacity];
        size = 0;
    }

    @Override
    public String add(String item) {
        validateItem(item);
        if (size == storage.length) {
            resizeArray();
        }
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItem(item);
        if (size == storage.length) {
            resizeArray();
        }
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        String replacedItem = storage[index];
        storage[index] = item;
        return replacedItem;
    }

    @Override
    public String remote(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                String remoteItem = storage[i];
                shiftStorageLeft(i);
                size--;
                return remoteItem;
            }

        }
        throw new ItemNotFoundException("Item not found in storage");
    }

    @Override
    public String remote(int index) {
        validateIndex(index);
        String removedItem = storage[index];
        shiftStorageLeft(index);
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size; i > 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(storage[index])){
                return storage[i];
            }
        }
        throw new ItemNotFoundException("Item not found in storage");
    }

    @Override
    public boolean equals(StringList otherList) {
        validateItem(otherList.toString());
        if (this == otherList){
            return true;
        }
        if (this.size != otherList.size()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!storage[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(storage,0,array,0,size);
        return array;
    }

    private void resizeArray() {
        int newCapacity = storage.length * 2;
        String[] newArray = new String[newCapacity];
        System.arraycopy(storage, 0, newArray, 0, size);
        storage = newArray;
    }

    private void shiftStorageLeft(int startIndex) {
        for (int i = startIndex; i <= size; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
    }

    public void validateSize() {
        if (size == storage.length) {
            throw new InvalidIndexException("index out if bounds");
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > storage.length) {
            throw new InvalidIndexException("Index out of bounds");
        }
    }

    public void validateItem(String item) {
        if (item == null) {
            throw new NullItemException("Null item are not allowed");
        }
    }
}
