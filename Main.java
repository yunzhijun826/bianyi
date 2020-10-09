import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class Main {
    public ArrayList<String> token = new ArrayList<String>();
    public void addList(){
        token.add("BEGIN");
        token.add("END");
        token.add("FOR");
        token.add("IF");
        token.add("THEN");
        token.add("ELSE");
    }
    public void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        int flag=0;
        Reader reader = null;
        reader = new InputStreamReader(new FileInputStream(file));
        int tempchar;
        int mark;
        int ok=0;
        tempchar = reader.read();
        mark=tempchar;
        while (ok==0) {
            flag=0;
            while((char)tempchar == '\n'||(char)tempchar == ' '||(char)tempchar == '\r'||(char)tempchar == '\t'){
                flag=1;
                tempchar = reader.read();
                if(tempchar==-1){
                    ok=1;
                    break;
                }
            }
            if((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'){
                flag=1;
                String s = "";
//                s=s+(char)tempchar;
//                tempchar = reader.read();
//                if(tempchar==-1) ok=1;
                while((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'||(char)tempchar>='0'&&(char)tempchar<='9'){
                    s=s+(char)tempchar;
                    tempchar = reader.read();
                    if(tempchar==-1){
                        ok=1;
                        break;
                    }
                    mark=tempchar;
                }
                tempchar=mark;
                if(token.contains(s)){
                    System.out.println(s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase());
                }
                else{
                    System.out.println("Ident("+s+")");
                }
                continue;
            }
            if(Character.isDigit((char)tempchar)){
                flag=1;
                String Int="";
//                Int=Int+(char)tempchar;
//                tempchar = reader.read();
//                if(tempchar==-1){
//                    ok=1;
//                }
                while((char)tempchar>='0'&&(char)tempchar<='9'){
                    Int=Int+(char)tempchar;
                    tempchar = reader.read();
                    if(tempchar==-1){
                        ok=1;
                        break;
                    }
                    mark=tempchar;
                }
                tempchar=mark;
                while(Int.charAt(0)=='0'&&Int.length()!=1){
                    Int=Int.substring(1);
                }
                System.out.println("Int("+Int+")");
                continue;
            }
            if((char)tempchar=='+'){
                System.out.println("Plus");
                flag=1;
            }
            if((char)tempchar==','){
                System.out.println("Comma");
                flag=1;
            }
            if((char)tempchar=='*'){
                System.out.println("Star");
                flag=1;
            }
            if((char)tempchar=='('){
                System.out.println("LParenthesis");
                flag=1;
            }
            if((char)tempchar==')'){
                System.out.println("RParenthesis");
                flag=1;
            }
            if((char)tempchar==':'){
                flag=1;
                tempchar = reader.read();
                if(tempchar==-1){
                    ok=1;
                }
                mark=tempchar;
                if((char)tempchar=='='){
                    System.out.println("Assign");
                }
                else{
                    tempchar=mark;
                    System.out.println("Colon");
                    continue;
                }
            }
            if(flag==0){
                System.out.println("Unknown");
                break;
            }
            tempchar = reader.read();
            if(tempchar==-1){
                break;
            }
            mark=tempchar;
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        Main m=new Main();
        m.addList();
        String filePath=args[0];
        m.readFile(filePath);

    }
}
