import java.util.*;

class HelloWorld{
    public static boolean main(String[] args){
        //Scanner sc = new Scanner(System.in);
        String name = "Stephen";
        int age = 21;
        boolean gender = true;
        boolean bodoh = true;
        List<String> random = new ArrayList<>();/*
        while (sc.hasNextLine()){
            random.add(sc.nextLine()+"\n");
        }*/
        random.add("I would like to go into AI specialisation.\n");
        random.add("I am in NUS Climbing Club.\n");
        random.add("I am terrible at Math.\n");
        Student stephen = new Student(name,age,gender,random,bodoh);
        System.out.println(stephen);
        System.out.println("Im the joke :)");
        return true;
    }
}

class Student{
    private String name;
    private boolean gender;
    private int age;
    private List<String> random;
    public boolean bodoh;
    private Random rg;
    public Student(String name, int age, boolean gender, List<String> randomFact,boolean bodoh){
        this.name = name;
        this.age = age;
        this.gender=gender;
        this.random = randomFact;
        this.bodoh = bodoh;
        this.rg = new Random();
    }
    private int getIndex(){
        int i =1+rg.nextInt(random.size()-1);
        return i;
    }
    @Override
    public String toString(){
        String intro = "Hi I am "+name+" aged ";
        String gender = (this.gender==true)?" male.":" female.";
        String randomfact = random.get(getIndex());
        String tanking = (bodoh == true)? "I will tank the CS2040S curve this semester!": "I will wreck the CS2040S curve this semester!";
        return intro+age+gender+"\n"+randomfact+tanking;
    }
}
