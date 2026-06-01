package main.java.ch10_collection.practice.model.service;

import main.java.ch10_collection.practice.model.vo.Member;

import java.util.List;
import java.util.Scanner;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	// 업다운 게임 시작
	// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
	// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
	public void startGame(Member loginMember) {
		System.out.println("[Game Start...]");
		int num = (int)(Math.random()*100)+1; // 임의의 난수 생성
		int count = 0; // 입력 횟수 0으로 초기화
		boolean isCorrect = false; // 정답 여부 판단 (처음엔 false)

		while (!isCorrect){ // isCorrect가 true가 될 때까지(정답을 맞출 때까지) 무한 반복
			System.out.println("숫자를 입력하세요: ");
			int guess = sc.nextInt(); // 사용자가 키보드로 입력한 숫자를 읽어옴
			count++; // 입력 횟수 1증가

			if (guess>num){
				System.out.println("Down");
			} else if (guess<num){
				System.out.println("Up");
			} else{
				System.out.println("정답!!");
				System.out.println("입력시도 횟수: "+count);
				isCorrect = true; // 반복문을 빠져나가기 위해 상태를 true로 변경
			}


		}
		HIghScore(loginMember, count); // 최고기록 확인하기 위한 메서드를 호출
		}
		public void HIghScore(Member member, int currentCount){
		if(member.getHighScore() == 0 || currentCount < member.getHighScore() ){
			// 기존 기록이 0(처음시도)이거나, 현재 시도가 최고기록보다 적을 때 (기록 경신)
			member.setHighScore(currentCount); // 최고기록 필드에 새로운 기록 저장
			System.out.println("***최고 기록 달성***");
		}
		}


	
	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {

		System.out.println("[내 정보 조회]");
		System.out.println("아이디: " + loginMember.getMemberId());
		System.out.println("이름: " + loginMember.getMemberName());
		System.out.println("최고점수: " + loginMember.getHighScore());
	}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출럭
	public void selectAllMember(List<Member> members) {
		// 외부에서 회원들이 담긴 리스트를 전달받아서 전체 출력하는 메서드
		
		System.out.println("[전체 회원 조회]");
		System.out.println("[아이디]\t[이름]\t[최고점수]");
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i) != null) { // members 리스트의 i번째 칸에 담긴 객체가 실제 데이터인지

				System.out.print(members.get(i).getMemberId()+"\t");
				System.out.print(members.get(i).getMemberName()+"\t");
				System.out.println(members.get(i).getHighScore());
				//members 리스트의 i번째 객체를 꺼내서(.get(i))
			}

		}
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {
		
		System.out.println("[비밀번호 변경]");
		System.out.println("현재 비밀번호 입력 : ");
		String pw = sc.nextLine();

		if (loginMember.getMemberPw().equals(pw)){
			System.out.println("새 비밀번호 : ");
			String newPw = sc.next();

			loginMember.setMemberPw(newPw);
			System.out.println("비밀번호가 변경되었습니다.");
		}else{
			System.out.println("현재 비밀번호가 일치하지 않습니다.");
		}
		
	}

}
