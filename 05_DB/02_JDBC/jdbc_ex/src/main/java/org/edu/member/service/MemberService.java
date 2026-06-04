package org.edu.member.service;

import org.edu.member.dao.MemberDaoImpl;
// import org.edu.member.dao.hesMemberDaoImpl;
import org.edu.member.dao.MemberDao;
import org.edu.member.vo.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberService {
    private Scanner sc = new Scanner(System.in);

    // 수업
    private MemberDao dao = new MemberDaoImpl();

    // 숙제
    // private MemberDao dao = new hesMemberDaoImpl();


    public void displayMenu() {


        int menu = 0; // 메뉴 선택용 변수

        do {
            try {
                System.out.println("[메인 메뉴]");
                System.out.println("1. 회원 등록");
                System.out.println("2. 회원 목록 조회");
                System.out.println("3. 회원 정보 조회");
                System.out.println("4. 회원 수정");
                System.out.println("5. 회원 삭제");
                System.out.println("6. 회원 부서명 조회");
                System.out.println("0. 종료");
                System.out.print("메뉴 선택 >> ");

                menu = sc.nextInt();
                sc.nextLine(); // 입력 버퍼 개행문자 제거
                System.out.println(); // 줄바꿈

                switch (menu) {
                    case 1:
                        create();
                        break;
                    case 2:
                        getList();
                        break;
                    case 3:
                      //  get();
                        break;
                    case 4:
                     //   update();
                        break;
                    case 5:
                     //   delete();
                        break;
                    case 6:
                        getDeptName();
                        break;


                    case 0:
                        System.out.println("[프로그램 종료]");
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
                }

            } catch (Exception e) {
                sc.nextLine(); // 잘못된 입력 제거
                e.printStackTrace();
            }
        } while (menu != 0);
    }

    // 회원 등록
    private void create() throws SQLException {
        System.out.println("=== 회원 등록 ===");

        // 아이디, 비밀번호, 이름, 권한을 입력받아 각각 변수에 저장
        System.out.print("아이디 : ");
        String memberId = sc.next();

        System.out.print("비밀번호 : ");
        String memberPw = sc.next();

        System.out.print("이름 : ");
        String memberName = sc.next();

        System.out.print("권한 : ");
        String memberRole = sc.next();

        // Member 객체 생성 후 전달
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberPw(memberPw);
        member.setMemberName(memberName);
        member.setMemberRole(memberRole);

        int result = dao.create(member);

        // 회원 등록 성공 시 : "OOO님의 가입을 환영합니다."
        //          실패 시 : "회원 등록 실패 ㅠㅠ"

        if (result == 1) {
            System.out.println(memberName + "님의 가입을 환영합니다.");
        } else {
            System.out.println("회원 등록 실패 ㅠㅠ");
        }

    }

    // 회원 정보 수정
    private void update() throws SQLException {

        System.out.println("=== 회원 정보 수정 ===");

        // 회원 번호를 입력 받아 일치하는 회원의 이름, 권한 수정
        System.out.print("수정할 회원 번호 : ");
        int no = sc.nextInt();
        sc.nextLine();

        System.out.print("수정할 이름 : ");
        String name = sc.nextLine();
        System.out.println(name);

        System.out.print("수정할 권한 : ");
        String role = sc.nextLine();

        Member member = new Member(no, name, role);

        int result = dao.update(member);
        // 성공 시 : "회원 정보 수정 성공"
        // 실패 시 : "회원 정보 수정 실패 ㅠㅠ"

        if (result == 1) System.out.println("회원 정보 수정 성공");
        else System.out.println("회원 정보 수정 실패 ㅠㅠ");
    }

    // delete()  : 회원 번호가 일치하는 회원 삭제
    private void delete() throws SQLException {
        System.out.println("=== 회원 정보 삭제 ===");

        System.out.print("삭제할 회원 번호 : ");
        int no = sc.nextInt();

        int result = dao.delete(no);

        if (result == 1) {
            System.out.println("회원 정보 삭제 성공");
        } else {
            System.out.println("회원 정보 삭제 실패");


        }
    }

    // get()     : 회원 번호가 일치하는 회원 한명 조회
    private void get() throws SQLException {
        System.out.println("=== 회원 정보 조회===");

        System.out.println("조회할 회원 번호 : ");
        int no = sc.nextInt();
        Member member = dao.get(no);

        if (member != null) {
            System.out.println("회원번호 : " + member.getMemberNo());
            System.out.println("아이디 : " + member.getMemberId());
            System.out.println("이름 : " + member.getMemberName());
            System.out.println("권한 : " + member.getMemberRole());
            System.out.println("탙퇴여부 : " + member.getDeletedYn());
        } else {
            System.out.println("존재하지 않는 회원번호입니다.");
        }

    }

    // getList() : 회원 목록 전체 조회
    private void getList() throws SQLException {
        System.out.println("=== 회원 목록 전체 조회 ===");

        List<Member> list = dao.getList();

        if (list == null || list.isEmpty()) {
            System.out.println("회원이 없습니다.");
        } else {
            for (Member member : list) {
                System.out.print(member.getMemberNo() + "\t");
                System.out.print(member.getMemberId() + "\t");
                System.out.print(member.getMemberName() + "\t");
                System.out.print(member.getMemberRole() + "\t");
                System.out.println(member.getDeleteYn());
                ;
            }
        }

    }

    // 회원 번호가 일치하는 회원의 번호, 이름, 부서코드, 부서명 조회
    private void getDeptName() throws SQLException {
        System.out.println("=== 회원 부서명 조회 ===");

        System.out.println("검색할 회원 번호 : ");
        int no = sc.nextInt();

        Member member = dao.getDeptName(no);

        if(member == null){
            System.out.println();
        }else{
            System.out.println();
        }

    }
}
