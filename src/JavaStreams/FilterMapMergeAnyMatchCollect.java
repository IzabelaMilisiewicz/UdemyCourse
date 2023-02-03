package JavaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterMapMergeAnyMatchCollect {
    @Test
    public void regular(){

    //count the number of names starting with "A"
    ArrayList<String> names = new ArrayList<String>();
    names.add("Aldona");
    names.add("Daniel");
    names.add("Adam");
    names.add("Rahul");
    names.add("Zbigniew");
    int count = 0;

    for (int i=0; i<names.size(); i++){
        String actual = names.get(i);
        if(actual.startsWith("A")){
            count++;
            System.out.println(actual);
        }
    }
    System.out.println(count);
}
    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Aldona");
        names.add("Daniel");
        names.add("Adam");
        names.add("Rahul");
        names.add("Zbigniew");

        //How to use filter in stream API
        //s=parameter which will scan through all (you can use any parameter)(this s is the same as count in the loop above, -> = lambda expression parameter and action
        //changing array into streams with our filter condition so here we will have only names started with "A"
        //it scans all names in parallel not in iterations as in normal for loop
        //terminal operation is count() here - without it we won't have anu output, it will return something only if is true (In out case, if we have names started with A)
        //filter is intermediate operation
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        //operations not affect original collection

        //below there is stream compatible array
        //on right side of lambda expression there is action, if our action takes more than one line, we can open {} and write everything inside
        long d = Stream.of("Aneta", "Mikołaj", "Agata", "Krzyś", "Alex", "Karol", "Max", "Iza").filter(s -> {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        //print all the names from the list which have more than 4 signs
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
//        String first = String.valueOf(names.stream().filter(s -> s.length()>4).findFirst());
//        System.out.println(first);
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
       public void streamMap() {

        //print names ended with "A" and print it n uppercase
        // .map method helps to modify our results for example to uppercase
        Stream.of("Aneta", "Mikołaj", "Agata", "Krzyś", "Alex", "Karol", "Max", "Iza").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //print names which have last letter as "a" with uppercase and sorted
        //startsWith is case-sensitive
        //how to change array into the list:
        List<String> names = Arrays.asList("Aneta", "Mikołaj", "Agata", "Krzyś", "Alex", "Karol", "Max", "Iza");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }

    @Test
        public void mergeAndAnyMatch(){

        //merging two different lists
        ArrayList<String> names2 = new ArrayList<String>();
        names2.add("Aldona");
        names2.add("Daniel");
        names2.add("Adam");
        names2.add("Rahul");
        names2.add("Zbigniew");

        List<String> names3 = Arrays.asList("Aneta", "Mikołaj", "Agata", "Krzyś", "Alex", "Karol", "Max", "Iza");

        Stream<String> newStream = Stream.concat(names2.stream(), names3.stream());
//        newStream.sorted().forEach(s->System.out.println(s));

        //once stream is modified you cannot again write on the stream, you have to create new one - that's why 93 line is commented
        //.anyMatch method helps to check if we have particular text in our list
        //.anyMatch works only for one list, but for any stream, not only concat
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);
        }

    @Test
    public void streamCollect(){

        //this method it used to collect your results and convert it back to any list
        //list -> new list

        List<String> ls = Stream.of("Igor", "Aneta", "Mikołaj", "Agata", "Krzyś", "Alex", "Karol", "Max", "Iza").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
        //print first element from the list
        System.out.println(ls.get(0));

        //print unique numbers from the array and sort it
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        values.stream().distinct().sorted().forEach(s->System.out.println(s));

        //give me only the third index
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }
}