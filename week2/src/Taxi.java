import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Taxi {
    static ArrayList<double[]> Taxi_list=new ArrayList<>();
    //static ArrayList<int[]> int_Taxi_list=new ArrayList<>();
    static int tn=0;
    static String[] location={"서울역","잠실역","회기역","고속터미널역","약수역"};




    public void Taxi_regist(){
        System.out.println("현재 차량의 종류는 택시 입니다");
        System.out.println("택시의 정보를 입력합니다");
        System.out.println("-------------------------");
        System.out.println("택시 기본정보 : ");
        System.out.println("최대 승객 수 : 4명");
        System.out.println("기본요금 : 2km까지 3800원");
        System.out.println("거리당 요금 : 132m당 100원");
        System.out.println("주유량 : 100L");
        int temp_fuel=100;
        System.out.println("속도 : 0km/h");
        int temp_speed=0;
        System.out.println("상태 : 일반");
        int temp_stat=2;
        System.out.println("현재 수입 : 0원");
        int temp_income=0;
        System.out.println("-------------------------");
        Scanner input= new Scanner(System.in);


        int temp_ps=0;
        int temp_departure=0;
        int temp_arrival=0;
        int temp_distance=0;
        int temp_fare=0;
        double[] taxi_info={tn+1,temp_stat,temp_ps,temp_fuel,temp_speed,temp_income,temp_departure,temp_arrival,temp_distance,temp_fare};
        System.out.println("-------------------------");
        System.out.println("["+(tn+1)+"]번 택시가 등록되었습니다.");
        System.out.println("-------------------------");
        Taxi_list.add(taxi_info);tn=tn+1;
    }

    public void Taxi_edit(){
        Scanner input = new Scanner(System.in);
        int check;
        if(Taxi_list.size()==0){
            System.out.println("---------------------------------");
            System.out.println("등록된 택시가 없습니다");
            System.out.println("---------------------------------");
        }
        else {
            int taxi_no=Taxi_list.size()+1;
            while (taxi_no  > Taxi_list.size()||taxi_no<0) {
                System.out.println("수정하실 택시의 번호를 입력해주세요.");
                try {
                    input = new Scanner(System.in);
                    taxi_no = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                }

                if (taxi_no  > Taxi_list.size()) {
                    System.out.println("택시의 번호가 " + Taxi_list.size() + "을(를) 초과했거나 숫자 양식이 아닙니다.");
                }
            }
            int[] int_Taxi= new int[Taxi_list.get(taxi_no-1).length];
            for (int i = 0; i < int_Taxi.length; i++) {
                int_Taxi[i]=(int) Taxi_list.get(taxi_no-1)[i];
            }

            System.out.println("---------------------------------");
            System.out.println("수정할 [" + int_Taxi[0] + "]번 택시 정보");
            if (Taxi_list.get(taxi_no-1)[3] < 10) {
                System.out.println("<<<주유가 필요합니다>>>");
            }
            System.out.println("- 최대승객 : 4명");
            System.out.println("- 현재 주유량 : " + int_Taxi[3] + "L");
            if (Taxi_list.get(taxi_no-1)[1] == 1) {
                int departure = (int) Taxi_list.get(taxi_no-1)[6];
                int arrival = (int) Taxi_list.get(taxi_no-1)[7];
                System.out.println("- 현재상태/속도 : " + "운행중 / " + int_Taxi[4] + "km/h");
                System.out.println("- 출발지->도착지 : " + location[departure] +" -> "+location[arrival]);
                System.out.println("- 운행거리 : " + Taxi_list.get(taxi_no-1)[8]+"km");
                System.out.println("- 요금 : " + Taxi_list.get(taxi_no-1)[9]  +"원");
            } else {
                System.out.println("- 현재상태/속도 : " + "일반 / " + int_Taxi[4] + "km/h");
            }
            System.out.println("- 현재 수입 : " + int_Taxi[5]+"원");

            int chage_index=0; int change_value=0;
            while (chage_index<1||chage_index>3){
                System.out.println("---------------------------------");
                System.out.println("수정할 항목을 선택해주세요.");
                System.out.println("1.승하차처리 2.주유량 3.속도");
                try{
                    input = new Scanner(System.in);
                    chage_index = input.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("숫자를 입력해주세요.");
                }
            }

            if(chage_index==1){//taxi_info={0-넘버,1-상태,2-승객,3-주유,4-속도,5-수입,6-출발,7-도착,8-거리,9-요금};
                if(Taxi_list.get(taxi_no-1)[1]==1){
                    System.out.println(taxi_no + "번 차량의 운행을 종료합니다.");
                    Taxi_list.get(taxi_no - 1)[5] = Taxi_list.get(taxi_no - 1)[4] + Taxi_list.get(taxi_no - 1)[9];
                    Taxi_list.get(taxi_no - 1)[2] = 0;
                    Taxi_list.get(taxi_no - 1)[6] = 0;
                    Taxi_list.get(taxi_no - 1)[7] = 0;
                    Taxi_list.get(taxi_no - 1)[8] = 0;
                    Taxi_list.get(taxi_no - 1)[9] = 0;
                    Taxi_list.get(taxi_no - 1)[1] = 2;
                }
                else {
                    if(Taxi_list.get(taxi_no - 1)[3] < 10){
                        System.out.println("주유량이 10L미만이라 운행이 불가능합니다.");
                        System.out.println("현재 주유량 : "+int_Taxi[3]+"L");
                    }
                    else {
                        int pasenger=0;check=0;
                        while (check==0) {
                            while (check == 0) {
                                check = 1;
                                System.out.println("승객수를 입력해주세요");
                                try {
                                    input = new Scanner(System.in);
                                    pasenger = input.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("숫자를 입력해주세요.");
                                    check = 0;
                                }
                            }
                            if (pasenger > 4) {
                                System.out.println("승객은 4명을 초과할 수 없습니다.");
                                check = 0;
                            }
                        }

                        double[] temp_chage=Taxi_receipt();
                        Taxi_list.get(taxi_no - 1)[6] =temp_chage[0];
                        Taxi_list.get(taxi_no - 1)[7] =temp_chage[1];
                        Taxi_list.get(taxi_no - 1)[8] =temp_chage[2];
                        Taxi_list.get(taxi_no - 1)[9] =temp_chage[3];
                        Taxi_list.get(taxi_no - 1)[1] =1;
                        System.out.println("[" + taxi_no + "]번 택시가 운행을 시작합니다.");
                        System.out.println("출발지 : "+location[(int) Taxi_list.get(taxi_no - 1)[6]]);
                        System.out.println("도착지 : "+location[(int) Taxi_list.get(taxi_no - 1)[7]]);
                        System.out.println("거리 : "+(int) Taxi_list.get(taxi_no - 1)[8]+"km");
                        System.out.println("요금 : "+(int) Taxi_list.get(taxi_no - 1)[9]+"원");



                    }
                }
            }
            if(chage_index==2){
                System.out.println("변동된 주유량를 입력해 주세요");
                System.out.println("예) 20->25 : 5 입력");
                System.out.println("예) 25->10 : -15 입력");
                try{
                    input = new Scanner(System.in);
                    change_value = input.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("숫자를 입력해주세요.");
                }
                if(Taxi_list.get(taxi_no-1)[3]+change_value<0){
                    System.out.println("현재 주유량은 (-)값이 될 수 없습니다.");
                }
                else {
                    System.out.println("[" + taxi_no + "]번 택시의 주유량이" + int_Taxi[3] + "L에서 " + (int_Taxi[3] + change_value) + "L로 변경되었습니다");
                    Taxi_list.get(taxi_no - 1)[3] = Taxi_list.get(taxi_no - 1)[3]+change_value;
                    if(Taxi_list.get(taxi_no - 1)[3]<10){
                        System.out.println("주유가 필요합니다.");
                        System.out.println("[" + taxi_no + "]번 택시의 주유량이 10L 미만이라 운행이 불가합니다.");
                    }
                    else if(Taxi_list.get(taxi_no - 1)[3]>10){
                        System.out.println("[" + taxi_no + "]번 택시의 주유가 완료되었습니다.");
                        Taxi_list.get(taxi_no - 1)[1]=1;
                    }
                }
            }
            if(chage_index==3){
                System.out.println("변동된 속도를 입력해 주세요");
                System.out.println("예) 20->25 : 5 입력");
                System.out.println("예) 25->10 : -15 입력");
                try{
                    input = new Scanner(System.in);
                    change_value = input.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("숫자를 입력해주세요.");
                }
                if(Taxi_list.get(taxi_no-1)[3]==0){
                    System.out.println("주유량이 부족하여 속도를 변경할 수 없습니다.");
                    System.out.println("주유량을 먼저 변경하여주세요.");
                }
                if(Taxi_list.get(taxi_no-1)[4]+change_value<0){
                    System.out.println("현재 속도는 (-)값이 될 수 없습니다.");
                }
                else {
                    System.out.println("[" + taxi_no + "]번 택시의 속도가" + int_Taxi[4] + "km/h에서 " + (int_Taxi[4] + change_value) + "km/h로 변경되었습니다");
                    Taxi_list.get(taxi_no - 1)[4] = Taxi_list.get(taxi_no - 1)[4]+change_value;
                }
            }

        }

    }

    public void Taxi_info(){
        if(Taxi_list.size()==0){
            System.out.println("---------------------------------");
            System.out.println("등록된 택시가 없습니다");
            System.out.println("---------------------------------");
        }
        else {

            for (int i = 0; i < Taxi_list.size(); i++) {
                int[] int_Taxi= new int[Taxi_list.get(i).length];
                for (int j = 0; j < int_Taxi.length; j++) {
                    int_Taxi[j]=(int) Taxi_list.get(i)[j];
                }
                System.out.println("---------------------------------");
                System.out.println("등록한 [" + int_Taxi[0] + "]번 택시 정보");
                if (Taxi_list.get(i)[3] < 10) {
                    System.out.println("<<<주유가 필요합니다>>>");
                }
                if (Taxi_list.get(i)[1] == 1) {
                    System.out.println("- 최대승객 : 4명");
                } else {
                    System.out.println("- 최대승객/현재승객 : 4명/"+Taxi_list.get(i)[2]+"명");
                }
                System.out.println("- 현재 주유량 : " + int_Taxi[3] + "L");
                if (Taxi_list.get(i)[1] == 1) {
                    int departure = (int) Taxi_list.get(i)[6];
                    int arrival = (int) Taxi_list.get(i)[7];
                    System.out.println("- 현재상태/속도 : " + "운행중 / " + int_Taxi[4] + "km/h");
                    System.out.println("- 출발지->도착지 : " + location[departure] +" -> "+location[arrival]);
                    System.out.println("- 운행거리 : " + Taxi_list.get(i)[8]+"km");
                } else {
                    System.out.println("- 현재상태/속도 : " + "일반 / " + int_Taxi[4] + "km/h");
                }
                System.out.println("- 현재 수입 : " + int_Taxi[5]+"원");
                System.out.println("---------------------------------");
            }
        }

    }
    public double[] Taxi_receipt(){
        //기본요금 : 2km까지 3800원
        //거리요금 : 132m 당 100원
        //거리표 :
        // 1-2 17km    2
        // 1-3 9.3km   3
        // 1-4 7.7km   4
        // 1-5 5.3km   5
        // 2-3 14km    6
        // 2-4 13km    8
        // 2-5 11km    10
        // 3-4 16km    12
        // 3-5 12km    15
        // 4-5 12km    20
        Scanner input;

        int departure=0;
        while (departure!=1&&departure!=2&&departure!=3&&departure!=4&&departure!=5){
            try {
                System.out.println("출발 지역을 선택해주세요.");
                System.out.println("1.서울역 2.잠실역 3.회기역 4.고속터미널역 5.약수역");
                input = new Scanner(System.in);
                departure = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }

        int arrival=0;
        while (arrival!=1&&arrival!=2&&arrival!=3&&arrival!=4&&arrival!=5){
            try {
                System.out.println("도착 지역을 선택해주세요.");
                System.out.println("1.서울역 2.잠실역 3.회기역 4.고속터미널역 5.약수역");
                input = new Scanner(System.in);
                arrival = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
            if(arrival==departure){
                System.out.println("출발지역과 도착지역이 같습니다.");
                System.out.println("도착지역을 다시 선택해주세요");
                arrival=0;
            }
        }

        int multiple=departure*arrival;
        double distance=0;
        switch (multiple){
            case 2 : distance=17;
                break;
            case 3 : distance=9.3;
                break;
            case 4 : distance=7.7;
                break;
            case 5 : distance=5.3;
                break;
            case 6 : distance=14;
                break;
            case 8 : distance=13;
                break;
            case 10 : distance=11;
                break;
            case 12 : distance=16;
                break;
            case 15 : distance=12;
                break;
            case 22 : distance=12;
                break;
        }
        int sum=0;
        if(distance<=2){
            sum=3800;
        }
        else {
            double temp_distance = distance * 1000 - 2000;
            double temp_sum = temp_distance / 132;
            sum = (int) temp_sum;
            sum = sum * 100+3800;
        }

        double[] temp_receipt={departure-1,arrival-1,distance,sum};
        return  temp_receipt;
    }


}
