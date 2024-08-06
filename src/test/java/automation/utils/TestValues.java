package automation.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class TestValues {
    public static class HeaderMenuElements {

       public final static List<String> HEADER_MENU_LIST = new ArrayList<>(Arrays.asList("SHOP", "MOST WANTED",
               "CATERGRIES", "ABOUT US", "CONTACT", "BLOG"))
                    .stream()
                    .collect(Collectors.toList());


    }


}
