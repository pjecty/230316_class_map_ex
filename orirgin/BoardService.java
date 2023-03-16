package orirgin;

import java.util.List;
import java.util.Scanner;


public class BoardService {
	// 데이터를 가공하는 역할
	BoardRepository br = new BoardRepository();
	Scanner sc = new Scanner(System.in);

	public void save() {
		BoardDTO boardDTO = new BoardDTO();
		System.out.print("제목>> ");
		boardDTO.setTitle(sc.nextLine());
		System.out.print("작성자>>");
		boardDTO.setWriter(sc.next());
		sc.nextLine();
		boolean success = br.save(boardDTO);
		if (success) {
			System.out.println("게시물 등록완료!");
		} else {
			System.out.println("게시물 등록실패~");
		}

	}

	public void findAll() {
		List<BoardDTO> list = br.findAll();
		System.out.println("글번호\t제목\t작성자\t조회수\t게시일\t");
		System.out.println("||---------------------------------------------||");
		for (BoardDTO b : list) {
			b.print();
		}
	}

	public void findById() {
		System.out.print("읽을 글번호>>>");
		String bno = sc.next();
		BoardDTO boardDTO = br.findById(bno);
		if (boardDTO == null) {
			System.out.println("찾을 수 없는 글입니다");
		} else {
			boardDTO.increaseCnt(); // BoardDTO 에 정의된 cnt 값을 하나 올리는 메소드호출 
			System.out.println("글번호\t제목\t\t작성자\t조회수\t게시일\t");
			System.out.println("||---------------------------------------------||");
			boardDTO.print();
		}
	}

	public void update() { // 수정의 기능을 하는 update 메소드 생성 
		System.out.print("수정할 글번호>> "); // 사용자안내 메세지 출력 
		String bno = sc.next(); // String bno에 글번호를 입력받음 
		BoardDTO b = br.findById(bno); // 입력받은 bno를 b에 저장 
		if (b == null) { // 만약 b가 null 이면 
			System.out.println("조회할 수 없는 글 번호 입니다"); // 조회할 수 없는 글번호 출력 
		} else { //  
			BoardDTO boardDTO = new BoardDTO();
			System.out.print("수정할 제목>> ");
			boardDTO.setTitle(sc.nextLine());
			boardDTO.setTitle(sc.nextLine());
			System.out.print("수정할 작성자>> ");
			boardDTO.setWriter(sc.next());
			sc.nextLine();

			if (br.update(boardDTO, bno)) {
				System.out.println("업데이트 완료^^!!");
			} else {
				System.out.println("업데이트 실패 ㅋㅋ");
			}
		}
	}

	public void delete() {

		System.out.print("삭제할 글번호>> ");
		String bno = sc.next();
		sc.nextLine();
		if (br.delete(bno)) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
		}
	}
}
