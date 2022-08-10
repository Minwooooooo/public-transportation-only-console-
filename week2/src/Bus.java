import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bus {
    static ArrayList<int[]> Bus_list=new ArrayList<int[]>();
    static int bn=0;
    //bus_info={bn+1,temp_stat,temp_ps,temp_fuel,temp_speed,temp_income};

    public void Bus_regist(){
        System.out.println("현재 차량의 종류는 버스 입니다");
        System.out.println("버스의 정보를 입력합니다");
        System.out.println("버스 기본정보 : ");
        System.out.println("최대 승객 수 : 30명");
        System.out.println("요금 : 1000원");
        System.out.println("주유량 : 100L");
        int temp_fuel=100;
        System.out.println("속도 : 0km/h");
        int temp_speed=0;
        System.out.println("상태 : 운행");
        int temp_stat=1;
        System.out.println("현재 수입 : 0원");
        int temp_income=0;
        Scanner input= new Scanner(System.in);
        int check;

        int temp_ps = 0;check=0;
        while (check==0) {
            while (check == 0) {
                while (check == 0) {
                    check = 1;
                    System.out.println("현재 승객수를 입력해주세요");
                    try {
                        input = new Scanner(System.in);
                        temp_ps = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        check = 0;
                    }
                }
                if (temp_ps > 30) {
                    System.out.println("승객수는 최대 승객수인 30명을 넘을 수 없습니다.");
                    check=0;
                } else {
                    check = 1;
                }
            }
            check = 0;
            while (check != 1) {
                System.out.println("현재 승객수는 " + temp_ps + " 명이 맞습니까? 맞을시 1, 아닐시 2");
                try {
                    input = new Scanner(System.in);
                    check = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                    check = 0;
                }
                if (check == 2) {
                    check = 0;
                }
            }
        }


        temp_income=temp_income+temp_ps*1000;
        int[] bus_info={bn+1,temp_stat,temp_ps,temp_fuel,temp_speed,temp_income};

        System.out.println("---------------------------------");
        System.out.println("등록한 [" + bn + "]번 버스 정보");
        System.out.println("- 최대승객/현재승객 : 30명 / " + temp_ps + "명");
        System.out.println("- 요금 : 1000원");
        System.out.println("- 현재 주유량 : 100L");
        System.out.println("- 현재상태/속도 : " + "운행중 / 0km/h");
        System.out.println("- 현재 수입 : 0원");
        System.out.println("---------------------------------");
        Bus_list.add(bus_info);bn=bn+1;
    }

    public void Bus_edit(){
        Scanner input = new Scanner(System.in);
        int check=0;
        if(Bus_list.size()==0){
            System.out.println("---------------------------------");
            System.out.println("등록된 버스가 없습니다");
            System.out.println("---------------------------------");
        }
        else {
            int bus_no=Bus_list.size()+1;
            while (bus_no  > Bus_list.size()||bus_no<0) {
                System.out.println("수정하실 버스의 번호를 입력해주세요.");
                try {
                    input = new Scanner(System.in);
                    bus_no = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                }

                if (bus_no  > Bus_list.size()) {
                    System.out.println("버스의 번호가 " + Bus_list.size() + "을(를) 초과했거나 숫자 양식이 아닙니다.");
                }
            }
            System.out.println("---------------------------------");
            System.out.println("수정할 [" + Bus_list.get(bus_no-1)[0] + "]번 버스 정보");
            if (Bus_list.get(bus_no-1)[3] < 10) {
                System.out.println("<<<주유가 필요합니다>>>");
            }
            System.out.println("- 최대승객/현재승객 : 30명 / " + Bus_list.get(bus_no-1)[2] + "명");
            System.out.println("- 요금 : 1000원");
            System.out.println("- 현재 주유량 : " + Bus_list.get(bus_no-1)[3] + "L");
            if (Bus_list.get(bus_no-1)[1] == 1) {
                System.out.println("- 현재상태/속도 : " + "운행중 / " + Bus_list.get(bus_no-1)[4] + "km/h");
            } else {
                System.out.println("- 현재상태/속도 : " + "차고지행 / " + Bus_list.get(bus_no-1)[4] + "km/h");
            }
            System.out.println("- 현재 수입 : " + Bus_list.get(bus_no-1)[5]+"원");
            System.out.println("---------------------------------");

            int chage_index=0; int change_value=0;
            while (chage_index<1||chage_index>3) {
                System.out.println("---------------------------------");
                System.out.println("수정할 항목을 선택해주세요.");
                System.out.println("1.현재 승객 2.주유량 3.속도");
                try {
                    input = new Scanner(System.in);
                    chage_index = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
            if(chage_index==1) {
                while (check == 0) {
                    while (check==0) {
                        check=1;
                        System.out.println("변동된 승객 수를 입력해 주세요");
                        System.out.println("예) 20->25 : 5 입력");
                        System.out.println("예) 25->10 : -15 입력");
                        try {
                            input = new Scanner(System.in);
                            change_value = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                            check=0;
                        }
                    }
                    if (Bus_list.get(bus_no - 1)[2] + change_value > 30) {
                        System.out.println("현재 승객수는 30명을 초과할 수 없습니다.");
                        check=0;
                    } else if (Bus_list.get(bus_no - 1)[2] + change_value < 0) {
                        System.out.println("현재 승객수는 (-)값이 될 수 없습니다.");
                        check=0;
                    } else {
                        System.out.println("[" + bus_no + "]번 버스의 현재승객수가 " + Bus_list.get(bus_no - 1)[2] + "명에서 " + (Bus_list.get(bus_no - 1)[2] + change_value) + "명으로 변경되었습니다");
                        Bus_list.get(bus_no - 1)[2] = Bus_list.get(bus_no - 1)[2] + change_value;
                        if (change_value > 0) {
                            Bus_list.get(bus_no - 1)[5] = Bus_list.get(bus_no - 1)[5] + change_value * 1000;
                        }
                    }
                }
            }
            if(chage_index==2){
                while (check==0) {
                    while (check==0) {
                        check=1;
                        System.out.println("변동된 주유량를 입력해 주세요");
                        System.out.println("예) 20->25 : 5 입력");
                        System.out.println("예) 25->10 : -15 입력");
                        try {
                            input = new Scanner(System.in);
                            change_value = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                            check=0;
                        }
                    }
                    if (Bus_list.get(bus_no - 1)[3] + change_value < 0) {
                        System.out.println("현재 주유량은 (-)값이 될 수 없습니다.");
                        check=0;
                    } else {
                        System.out.println("[" + bus_no + "]번 버스의 주유량이" + Bus_list.get(bus_no - 1)[3] + "L에서 " + (Bus_list.get(bus_no - 1)[3] + change_value) + "L로 변경되었습니다");
                        Bus_list.get(bus_no - 1)[3] = Bus_list.get(bus_no - 1)[3] + change_value;
                        if (Bus_list.get(bus_no - 1)[3] < 10 && Bus_list.get(bus_no - 1)[1] == 1) {
                            System.out.println("주유가 필요합니다.");
                            System.out.println("[" + bus_no + "]번 버스의 주유량이 10L 미만이라 [차고지행]으로 변경됩니다");
                            Bus_list.get(bus_no - 1)[1] = 2;
                        } else if (Bus_list.get(bus_no - 1)[3] > 10 && Bus_list.get(bus_no - 1)[1] == 2) {
                            System.out.println("[" + bus_no + "]번 버스의 주유가 완료되어 [운행중]으로 변경됩니다");
                            Bus_list.get(bus_no - 1)[1] = 1;
                        }
                    }
                }
            }
            if(chage_index==3){
                while (check==0) {
                    while (check == 0) {
                        check=1;
                        System.out.println("변동된 속도를 입력해 주세요");
                        System.out.println("예) 20->25 : 5 입력");
                        System.out.println("예) 25->10 : -15 입력");
                        try {
                            input = new Scanner(System.in);
                            change_value = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                            check=0;
                        }
                    }
                    if (Bus_list.get(bus_no - 1)[3] == 0) {
                        System.out.println("주유량이 부족하여 속도를 변경할 수 없습니다.");
                        System.out.println("주유량을 먼저 변경하여주세요.");
                    }
                    if (Bus_list.get(bus_no - 1)[4] + change_value < 0) {
                        System.out.println("현재 속도는 (-)값이 될 수 없습니다.");
                        check=0;
                    } else {
                        System.out.println("[" + bus_no + "]번 버스의 속도가" + Bus_list.get(bus_no - 1)[4] + "km/h에서 " + (Bus_list.get(bus_no - 1)[4] + change_value) + "km/h로 변경되었습니다");
                        Bus_list.get(bus_no - 1)[4] = Bus_list.get(bus_no - 1)[4] + change_value;
                    }
                }
            }

        }

    }

    public void Bus_info(){
        if(Bus_list.size()==0){
            System.out.println("---------------------------------");
            System.out.println("등록된 버스가 없습니다");
            System.out.println("---------------------------------");
        }
        else {//bus_info={bn+1,temp_stat,temp_ps,temp_fuel,temp_speed,temp_income};
            for (int i = 0; i < Bus_list.size(); i++) {
                System.out.println("---------------------------------");
                System.out.println("등록한 [" + Bus_list.get(i)[0] + "]번 버스 정보");
                if (Bus_list.get(i)[3] < 10) {
                    System.out.println("<<<주유가 필요합니다>>>");
                }
                System.out.println("- 최대승객/현재승객 : 30명 / " + Bus_list.get(i)[2] + "명");
                System.out.println("- 요금 : 1000원");
                System.out.println("- 현재 주유량 : " + Bus_list.get(i)[3] + "L");
                if (Bus_list.get(i)[1] == 1) {
                    System.out.println("- 현재상태/속도 : " + "운행중 / " + Bus_list.get(i)[4] + "km/h");
                } else {
                    System.out.println("- 현재상태/속도 : " + "차고지행 / " + Bus_list.get(i)[4] + "km/h");
                }
                System.out.println("- 현재 수입 : " + Bus_list.get(i)[5]+"원");
                System.out.println("---------------------------------");
            }
        }

    }

}
