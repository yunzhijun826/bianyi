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
        Reader reader = null;
        reader = new InputStreamReader(new FileInputStream(file));
        int tempchar;
        while ((tempchar = reader.read()) != -1) {
            while((char)tempchar == '\n'||(char)tempchar == ' '||(char)tempchar == '\r'){
                tempchar = reader.read();
            }
            if((char)tempchar>='a'&&(char)tempchar<='z'||(char)tempchar>='A'&&(char)tempchar<='Z'){
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
                    System.out.println("\r"+s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase());
                }
                else{
                    System.out.println("\rIdent("+s+")");
                }
            }
            else if(Character.isDigit((char)tempchar)){
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
                System.out.println("\rInt("+Int+")");
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
                        System.out.println("\r"+s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase());
                    }
                    else{
                        System.out.println("\rIdent("+s+")");
                    }
                }
            }
            else if((char)tempchar=='+'){
                System.out.println("\rPlus");
            }
            else if((char)tempchar==','){
                System.out.println("\rComma");
            }
            else if((char)tempchar=='*'){
                System.out.println("\rStar");
            }
            else if((char)tempchar=='('){
                System.out.println("\rLParenthesis");
            }
            else if((char)tempchar==')'){
                System.out.println("\rRParenthesis");
            }
            else if((char)tempchar==':'){
                tempchar = reader.read();
                if((char)tempchar=='='){
                    System.out.println("\rAssign");
                }
                else{
                    System.out.println("\rColon");
                }
            }
            else{
                System.out.println("\rUnknown");
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
