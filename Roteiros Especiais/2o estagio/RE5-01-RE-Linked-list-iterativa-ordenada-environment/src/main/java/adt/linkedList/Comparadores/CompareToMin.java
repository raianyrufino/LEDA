package adt.linkedList.Comparadores;

import adt.linkedList.ordered.OrderedSingleLinkedListImpl;

import java.util.Comparator;

public class CompareToMin implements Comparator<Object> {

    @Override
    public int compare(Object item1, Object item2) {
        return item1.compareTo(item2);
    }

}
