import java.util.InputMismatchException;
import java.util.Scanner;

public class controller {

    public int hello(){
        int temp_hello=0;
        while (temp_hello!=1 && temp_hello!=2) {
            System.out.println("JAVA 대중교통 통합관리 시스템입니다.");
            System.out.println("해당 시스템은 숫자와 엔터키로만 조작이 가능합니다.");
            System.out.println("아래 메뉴에서 희망하는 기능을 선택하여 해당 번호를 기입해주세요.");
            System.out.println("1.차량 등록  2.차량 정보 조회 및 변경");
            Scanner menu = new Scanner(java.lang.System.in);
            try{
                temp_hello = menu.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("숫자를 입력해 주세요.");
                temp_hello=0;
            }
        }
        return temp_hello;
    }

    public int regist(){
        int temp_regist=0;
        int temp_main=0;
        while(temp_regist>3||temp_regist<=0) {
            System.out.println("JAVA 대중교통 통합관리 시스템 [차량등록 서비스] 입니다.");
            System.out.println("해당 시스템은 숫자와 엔터키로만 조작이 가능합니다.");
            System.out.println("아래 메뉴에서 차량 종류를 선택하여 해당 번호를 기입해주세요.");
            System.out.println("1.버스  2.택시  3.뒤로가기");
            try {
                Scanner regist = new Scanner(java.lang.System.in);
                temp_regist = regist.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요.");
                temp_regist = 0;
            }
        }
        while (temp_regist == 1 || temp_regist == 2) {
            if (temp_regist == 1) {
                Bus regist = new Bus();
                regist.Bus_regist();
                temp_regist=0;
            }
            if (temp_regist == 2) {
                Taxi regist = new Taxi();
                regist.Taxi_regist();
                temp_regist=0;
            }
            while (temp_regist!=1&&temp_regist!=2&&temp_regist!=3&&temp_regist!=4) {
                System.out.println("추가 버스 등록을 원하시면 1번, 추가 택시등록을 원하시면 2번");
                System.out.println("차량 정보를 조회하시려면 3번, 메인메뉴로 이동하시려면 4번을 눌러주세요");
                try {
                    Scanner input1 = new Scanner(java.lang.System.in);
                    temp_regist = input1.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해 주세요.");
                }
            }
            if(temp_regist==3){
                temp_regist=4;
            }
            else if(temp_regist==4){
                temp_regist=3;
            }
        }
        if (temp_regist == 3) {
            temp_main=1;
        }
        if (temp_regist ==4) {
            temp_main=3;
        }

        return temp_main;
    }

    public int info(){
        int temp_main=0;
        int temp_info=0;
        while(temp_info!=1&&temp_info!=2&&temp_info!=3&&temp_info!=4&&temp_info!=5) {
            System.out.println("JAVA 대중교통 통합관리 시스템 [차량 정보 조회 서비스] 입니다.");
            System.out.println("해당 시스템은 숫자와 엔터키로만 조작이 가능합니다.");
            System.out.println("아래 메뉴에서 희망하는 기능을 선택하여 해당 번호를 기입해주세요.");
            System.out.println("1.버스 정보 보기  2.택시 정보 보기");
            System.out.println("3.버스 정보 변경  4.택시 정보 변경");
            System.out.println("5.메인메뉴로 이동");
            try {
                Scanner info = new Scanner(java.lang.System.in);
                temp_info = info.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요.");
                temp_info = 0;
            }
        }
        if (temp_info==5){
            temp_main=1;
        }
        if (temp_info==1){
            Bus info=new Bus();
            info.Bus_info();
            temp_main=3;
        }
        if(temp_info==3){
            Bus edit=new Bus();
            edit.Bus_edit();
            temp_main=3;
        }
        if (temp_info==2){
            Taxi info=new Taxi();
            info.Taxi_info();
            temp_main=3;
        }
        if (temp_info==4){
            Taxi edit=new Taxi();
            edit.Taxi_edit();
            temp_main=3;
        }
        return temp_main;
    }
}
