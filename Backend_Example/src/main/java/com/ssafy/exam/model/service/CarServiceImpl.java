package com.ssafy.exam.model.service;


import java.util.List;

import com.ssafy.exam.model.dao.CarDaoImpl;
import com.ssafy.exam.model.dao.CarDao;
import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.model.dto.Car;


public class CarServiceImpl implements CarService {
	/*싱글톤 형태로 완성되어 제공 됨*/
    private CarDao dao = CarDaoImpl.getInstance();

    private static CarServiceImpl service = new CarServiceImpl();

    private CarServiceImpl() {
    }

    public static CarServiceImpl getService() {
        return service;
    }
    
	///////////////////////////////////////////////////////
	//------아래 메소드를 확인하고 코드를 완성하세요.---------------//
	///////////////////////////////////////////////////////

	@Override
	public Member login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email,password);
	}

	@Override
	public List<Car> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
	// 상세 조회
	@Override
    public Car get(String code) {
        return dao.get(code);
    }

	@Override
	public int insert(Car car) {
		// TODO Auto-generated method stub
		return dao.insert(car);
	}

	@Override
	public int modify(Car car) {
		// TODO Auto-generated method stub
		return dao.modify(car);
	}
    
	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return dao.delete(code);
	}


}
