package affinity.spindown.DieLogic;

import java.util.ArrayList;

/**
 * Created by 4th3ist on 6/24/2016.
 */
public class StringUtils {

    public static String findSub(String string){
        String sub = null;
        if(string.contains("(")&&string.contains(")")){
            int last = 0;
            char[] chars = string.toCharArray();
            for(int pos = 0;pos<chars.length;pos++){
                if(chars[pos]=='('){
                    last = pos;
                }else if(chars[pos]==')'){
                    sub = string.substring(last+1, pos);
                    break;
                }
            }
        }else{
            return string;
        }
        return sub;
    }

    /*public static String[] separate(String string){
        ArrayList<String> strings = new ArrayList<String>();
        char[] chars = string.toCharArray();
        boolean workingOnNumber;
        if(Character.isDigit(chars[0])){
            workingOnNumber=true;
        }else{
            workingOnNumber=false;
        }
        int b = 0;
        for(int a = 0;a<chars.length;a++){
            if (workingOnNumber) {
                if(!Character.isDigit(chars[a])){
                    strings.add(String.copyValueOf(chars, b, a-b));
                    b=a;
                    workingOnNumber=false;
                }
            }else{
                if(Character.isDigit(chars[a])){
                    strings.add(String.copyValueOf(chars, b, a-b));
                    b=a;
                    workingOnNumber=true;
                }
            }
        }
        strings.add(String.copyValueOf(chars, b, chars.length-b));
        Object[] objs = strings.toArray();
        String[] strs = new String[objs.length];
        for(int a = 0;a<objs.length;a++){
            strs[a]=(String)objs[a];
        }
        return strs;
    }*/
    private static boolean isNumber(String str){
        if(Character.isDigit(str.toCharArray()[0])){
            return true;
        }else{
            return false;
        }
    }

    public static String[] doMultiplcation(String[] strings){
        ArrayList<String> strs = new ArrayList<String>();
        boolean isNumber;
        boolean doneCalc = false;
        for(int a = 0;a<strings.length;a++){
            if(a>0){
                isNumber = isNumber(strings[a]);
                if(strings[a].equals("*")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))*Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])*Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(isNumber&&doneCalc){
                }else if(doneCalc){
                    doneCalc=false;
                }else{
                    strs.add(strings[a-1]);
                }
            }
        }
        if (!doneCalc)
            strs.add(strings[strings.length-1]);
        String[] strsA = new String[strs.size()];
        Object[] objs = strs.toArray();
        for(int a = 0;a<strsA.length;a++){
            strsA[a]=(String)objs[a];
        }
        return strsA;
    }

    public static String[] doDivide(String[] strings){
        ArrayList<String> strs = new ArrayList<String>();
        boolean isNumber;
        boolean doneCalc = false;
        for(int a = 0;a<strings.length;a++){
            if(a>0){
                isNumber = isNumber(strings[a]);
                if(strings[a].equals("/")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))/Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])/Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(isNumber&&doneCalc){
                }else if(doneCalc){
                    doneCalc=false;
                }else{
                    strs.add(strings[a-1]);
                }
            }
        }
        if (!doneCalc)
            strs.add(strings[strings.length-1]);
        String[] strsA = new String[strs.size()];
        Object[] objs = strs.toArray();
        for(int a = 0;a<strsA.length;a++){
            strsA[a]=(String)objs[a];
        }
        return strsA;
    }

    public static String[] doAddition(String[] strings){
        ArrayList<String> strs = new ArrayList<String>();
        boolean isNumber;
        boolean doneCalc = false;
        for(int a = 0;a<strings.length;a++){
            if(a>0){
                isNumber = isNumber(strings[a]);
                if(strings[a].equals("+")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))+Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])+Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(isNumber&&doneCalc){
                }else if(doneCalc){
                    doneCalc=false;
                }else{
                    strs.add(strings[a-1]);
                }
            }
        }
        if (!doneCalc)
            strs.add(strings[strings.length-1]);
        String[] strsA = new String[strs.size()];
        Object[] objs = strs.toArray();
        for(int a = 0;a<strsA.length;a++){
            strsA[a]=(String)objs[a];
        }
        return strsA;
    }

    public static String[] doSubtraction(String[] strings){
        ArrayList<String> strs = new ArrayList<String>();
        boolean isNumber;
        boolean doneCalc = false;
        for(int a = 0;a<strings.length;a++){
            if(a>0){
                isNumber = isNumber(strings[a]);
                if(strings[a].equals("-")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))-Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])-Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(isNumber&&doneCalc){
                }else if(doneCalc){
                    doneCalc=false;
                }else{
                    strs.add(strings[a-1]);
                }
            }
        }
        if (!doneCalc)
            strs.add(strings[strings.length-1]);
        String[] strsA = new String[strs.size()];
        Object[] objs = strs.toArray();
        for(int a = 0;a<strsA.length;a++){
            strsA[a]=(String)objs[a];
        }
        return strsA;
    }
    public static String[] doMultAndDiv(String[] strings){
        ArrayList<String> strs = new ArrayList<String>();
        boolean isNumber;
        boolean doneCalc = false;
        for(int a = 0;a<strings.length;a++){
            if(a>0){
                isNumber = isNumber(strings[a]);
                if(strings[a].equals("/")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))/Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])/Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(strings[a].equals("*")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))*Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])*Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(isNumber&&doneCalc){
                }else if(doneCalc){
                    doneCalc=false;
                }else{
                    strs.add(strings[a-1]);
                }
            }
        }
        if(!doneCalc){
            strs.add(strings[strings.length-1]);
        }
        String[] strsA = new String[strs.size()];
        Object[] objs = strs.toArray();
        for(int a = 0;a<strsA.length;a++){
            strsA[a]=(String)objs[a];
        }
        return strsA;
    }
    public static String[] doAddAndSub(String[] strings){
        ArrayList<String> strs = new ArrayList<String>();
        boolean isNumber;
        boolean doneCalc = false;
        for(int a = 0;a<strings.length;a++){
            if(a>0){
                isNumber = isNumber(strings[a]);
                if(strings[a].equals("-")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))-Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])-Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(strings[a].equals("+")){
                    if(doneCalc){
                        double res = Double.parseDouble(strs.get(strs.size()-1))+Double.parseDouble(strings[a+1]);
                        strs.set(strs.size()-1,String.valueOf(res));
                    }else{
                        double res = Double.parseDouble(strings[a-1])+Double.parseDouble(strings[a+1]);
                        strs.add(String.valueOf(res));
                    }
                    doneCalc=true;
                }else if(isNumber&&doneCalc){
                }else if(doneCalc){
                    doneCalc=false;
                }else{
                    strs.add(strings[a-1]);
                }
            }
        }
        if(!doneCalc){
            strs.add(strings[strings.length-1]);
        }
        String[] strsA = new String[strs.size()];
        Object[] objs = strs.toArray();
        for(int a = 0;a<strsA.length;a++){
            strsA[a]=(String)objs[a];
        }
        return strsA;
    }
}