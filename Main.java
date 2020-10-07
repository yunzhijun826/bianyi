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
        while ((tempchar = reader.read()) != -1) {
            flag=0;
            while((char)tempchar == '\n'||(char)tempchar == ' '||(char)tempchar == '\r'||(char)tempchar == '\t'){
                tempchar = reader.read();
                flag=1;
            }
            if((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'){
                flag=1;
                String s = "";
                //System.out.println(s);
//                s.append((char)tempchar);
                s=s+(char)tempchar;
                tempchar = reader.read();
                while((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'||(char)tempchar>='0'&&(char)tempchar<='9'){
//                    s.append((char)tempchar);
                    s=s+(char)tempchar;
                    tempchar = reader.read();
                }
                if(token.contains(s)){
//                    s.substring(0, 1).toUpperCase();
//                    s.substring(1).toLowerCase();
                    System.out.println(s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase());
                }
                else{
                    System.out.println("Ident("+s+")");
                }
            }
            if(Character.isDigit((char)tempchar)){
                flag=1;
                String Int="";
                Int=Int+(char)tempchar;
                tempchar = reader.read();
                while((char)tempchar>='0'&&(char)tempchar<='9'){
                    Int=Int+(char)tempchar;
                    tempchar = reader.read();
                }
                while(Int.charAt(0)=='0'&&Int.length()!=1){
                    Int=Int.substring(1);
                }
                System.out.println("Int("+Int+")");
                if((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'){
                    String s = "";
                    s=s+(char)tempchar;
                    tempchar = reader.read();
                    while((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'||(char)tempchar>='0'&&(char)tempchar<='9'){
//                    s.append((char)tempchar);
                        s=s+(char)tempchar;
                        tempchar = reader.read();
                    }
                    if(token.contains(s)){
                        System.out.println(s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase());
                    }
                    else{
                        System.out.println("Ident("+s+")");
                    }
                }
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
                if((char)tempchar=='='){
                    System.out.println("Assign");
                }
                else{
                    System.out.println("Colon");
                }
            }
            if(flag==0){
                System.out.println("Unknown");
                break;
            }
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        Main m=new Main();
        m.addList();
        //Scanner input=new Scanner(System.in);
        String filePath=args[0];
        //String filePath=input.next();
        m.readFile(filePath);

    }
}
