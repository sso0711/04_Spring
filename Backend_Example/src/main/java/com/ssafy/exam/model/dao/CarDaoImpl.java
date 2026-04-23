package com.ssafy.exam.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;

/*
 * 초기 정보 파일 입출력 관련 처리는 완성된 형태로 제공된다.*/
/* 싱글톤 형태로 완성되어 제공 됨*/
public class CarDaoImpl implements CarDao {
	private static final CarDaoImpl instance = new CarDaoImpl();
	private final File memberDataFile, carDataFile;
	private List<Member> members;
	private List<Car> cars;

	public static CarDaoImpl getInstance() {
		return instance;
	}

	private CarDaoImpl() {
		// file 초기화
		String path = CarDaoImpl.class.getResource("/").getPath() + "member.dat";
		memberDataFile = new File(path);
		path = CarDaoImpl.class.getResource("/").getPath() + "car.dat";
		carDataFile = new File(path);

		try {
			if (!memberDataFile.exists()) {
				memberDataFile.createNewFile();
			}
			if (carDataFile.exists()) {
				carDataFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try (ObjectInputStream memOis = new ObjectInputStream(new FileInputStream(memberDataFile));
				ObjectInputStream carOis = new ObjectInputStream(new FileInputStream(carDataFile))) {
			members = (List) memOis.readObject();
			cars = (List) carOis.readObject();
			if (members.size() == 0)
				reset(null);
			if (cars.size() == 0)
				carReset(null);
			System.out.println("회원 정보 로딩 완료: " + members.size() + "명");
			System.out.println("차량 정보 로딩 완료:" + cars.size() + "개");
		} catch (Exception e) {
			System.out.println("저장된 정보가 없습니다.");
			members = Collections.synchronizedList(new ArrayList<>());
			cars = Collections.synchronizedList(new ArrayList<>());
		}
	}

	public void save() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(memberDataFile));
				ObjectOutputStream carOos = new ObjectOutputStream(new FileOutputStream(carDataFile))) {
			oos.writeObject(members);
			System.out.println("회원 정보 저장 완료");
			carOos.writeObject(cars);
			System.out.println("차량 정보 저장 완료");
		} catch (Exception e) {
			throw new RuntimeException("정보 저장 실패", e);
		}
	}

	public void reset(Connection con) {
		synchronized (members) {
			int length = 10;
			members.clear();
			for (int i = 0; i < length; i++) {
				members.add(new Member(i, "테스트" + (length - i), "test" + i + "@ssafy.com", "1234", "USER"));
			}
			members.add(new Member(100, "관리자", "admin@ssafy.com", "1234", "ADMIN"));
			System.out.println("멤버 초기화 완료 " + members.size() + " :" + members.get(0));
		}
	}

	public void carReset(Connection con) {
		synchronized (cars) {
			cars.clear();
			cars.add(new Car("ABC-123", "A6", 7000, "아우디", "대형"));
			cars.add(new Car("DEF-456", "쏘나타", 3100, "현대", "중형"));
			cars.add(new Car("GHI-789", "쏘렌토", 3500, "기아", "대형"));
			System.out.println("차량 정보 초기화 완료 " + cars.size() + " :" + cars.get(0));
		}
	}
	
	///////////////////////////////////////////////////////
	//------아래 메소드를 확인하고 코드를 완성하세요.---------------//
	///////////////////////////////////////////////////////
	/// 
	@Override
	public Member login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Car car) {
		// TODO Auto-generated method stub
		return 0;
	}





}
