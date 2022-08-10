public class main {
    public static void main(String[] args) {
        int temp_main=1;

        while(temp_main==1 || temp_main==2 || temp_main==3){
            if(temp_main==1){
                controller input=new controller();
                temp_main=input.hello()+1;
            }

            if(temp_main==2){
                controller input=new controller();
                temp_main=input.regist();
            }

            if(temp_main==3){
                controller input=new controller();
                temp_main=input.info();
            }

        }

    }
}
