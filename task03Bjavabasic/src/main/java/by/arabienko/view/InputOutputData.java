package by.arabienko.view;


import by.arabienko.entity.ProgramGuide;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Data Input and Output.
 */
public class InputOutputData {


    public void output(final String arg) {
       System.out.println(arg);
    }

    public void output(final String label, final double arg) {
        System.out.print(label + arg);
        System.out.println();
    }

    public void output(final int i, final char arg) {
        System.out.println("number " + i + " - " + arg + " ");
    }

    public void output(final HashMap hashMap, final String str){
        Iterator<Map.Entry<String, ProgramGuide.Program>> entries =
                hashMap.entrySet().iterator();
        System.out.println(str);
        while (entries.hasNext()) {
            Map.Entry<String, ProgramGuide.Program> entry =
                    entries.next();
            System.out.println(entry.getValue());
        }
    }

    public void output(final HashMap hashMap, final String str, String time){
        Iterator<Map.Entry<String, ProgramGuide.Program>> entries =
                hashMap.entrySet().iterator();
        System.out.println(str+" "+ time);
        while (entries.hasNext()) {
            Map.Entry<String, ProgramGuide.Program> entry =
                    entries.next();
            System.out.println(entry.getKey()+"  " +entry.getValue());
        }
    }
}
