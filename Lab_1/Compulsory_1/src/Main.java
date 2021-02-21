public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!\n");

        String[] languages = {"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};
        int result = (int) (Math.random() * 1_000_000);
        result = result * 3;
        String binary = "10101";
        result = result + Integer.parseInt(binary, 2);
        result = result + 0xFF;
        result = result * 6;

        int m, c;
        while(result>10)
        {
            m=result;
            c=0;
            while(m>0)
            {
                c=c+m%10;
                m=m/10;
            }
            result=c;
        }

        System.out.println("Willy-nilly,this semester I will learn " + languages[result]);

    }
}