이노베이션 캠프 in 강원 Spring 2주차 과제
--------------------------------------
#### <콘솔로 운용하는 대중교통 서비스>

***

### Class 구성

- **main**

- **controller**
  - hello : 시작 콘솔
  - info : 대중교통 정보를 확인하고 수정하기위해 Taxi 클래스나 Bus 클래스와 연결하는 콘솔
  - regist : 대중교통을 등록하기 위한 콘솔

- **Taxi**
  - Taxi_regist : 택시 등록(기본형으로 등록)
  - Taxi_edit : 택시 정보 수정 및 승하차 처리
  - Taxi_info : 등록된 모든 택시정보 열람
  - Taxi_receipt : 출발지와 목적지 선택 및 이동 거리에 따른 택시비 계산

- **Bus**
  - Bus_regist : 버스 등록(기본형+현재승객)
  - Bus_edit : 택시 정보 수정
  - Bus_info : 등록된 모든 버스정보 열람
  
### 주요 기능

1. Scanner를 통한 콘솔이용
2. try~catch를 활용하여 콘솔이용간 InputMismatchException 발생시 멈춤 방지
```java
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
```

### 세부 사항
**Taxi**

|등록|--by console-->|수정|
|------------------|--------|---------------------|
|등록한 [1]번 택시 정보| |수정한 [1]번 택시 정보|
|- 최대승객 : 4명     | | - 최대승객 : 4명|
|- 현재 주유량 : 100L | |  - 현재 주유량 : 100L           |
|- 현재상태/속도 : 일반 / 0km/h|| - 현재상태/속도 : 운행중 / 0km/h |
|- 현재 수입 : 0원||- 출발지->도착지 : 서울역 -> 고속터미널역 |
|||- 운행거리 : 7.7km|
|||- 현재 수입 : 0원|

* 현재수입은 이후 하차시 갱신

**Bus**







