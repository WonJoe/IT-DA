import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import address from '../API_KEY';
import LocationWrite from './LocationWrite'; // LocationWrite 컴포넌트를 import

const CreateUser = (props) => {
  const [createData, setCreateData] = useState({
    users: {
      userId: '',
      userPassword: ''
    },
    location: {
      lat: '',
      lng: '',
      address: '' // 주소 필드 추가
    }
  },[]);
  
  // LocationWrite 컴포넌트의 열림/닫힘 상태를 관리하는 변수와 함수
  const [isOpen, setIsOpen] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    const category = name.split('.')[0]; // users or location
    const field = name.split('.')[1]; // userId, userName, lat, lng, or address

    setCreateData((prevData) => ({
      ...prevData,
      [category]: {
        ...prevData[category],
        [field]: value,
      },
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch(`${address.backendaddress}/users/create`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(createData),
    })
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        props.history.push('/');
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  // LocationWrite를 열고 닫는 함수
  const toggleLocationWrite = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div>
      
      
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3">
          <Form.Label>아이디</Form.Label>
          <Form.Control
            type="text"
            name="users.userId"
            value={createData.users.userId}
            onChange={handleChange}
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>비밀번호</Form.Label>
          <Form.Control
            type="text"
            name="users.userPassword"
            value={createData.users.userPassword}
            onChange={handleChange}
          />
        </Form.Group>
        

        <Form.Group className="mb-3">
          <Form.Label>주소</Form.Label>
          <Form.Control
            type="text"
            name="location.address"
            value={createData.location.address}
            onChange={handleChange}
          />
        </Form.Group>

        </Form>

        {/* LocationWrite 컴포넌트를 토글할 버튼 */}
        <Button onClick={toggleLocationWrite}>
          {isOpen ? '주소 선택 닫기' : '주소 선택 열기'}
        </Button>
        
        {/* isOpen 상태에 따라 LocationWrite 컴포넌트를 보여주거나 감춥니다 */}
        {isOpen && (
          <LocationWrite setCreateData={setCreateData} />
        )}
        <br/>

        <Form>

        <Form.Group className="mb-3">
          <Form.Label>위도</Form.Label>
          <Form.Control
            type="text"
            name="location.lat"
            value={createData.location.lat}
            onChange={handleChange}
            disabled="disabled"
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>경도</Form.Label>
          <Form.Control
            type="text"
            name="location.lng"
            value={createData.location.lng}
            onChange={handleChange}
            disabled="disabled"
          />
        </Form.Group>

        
        <br/>

        <Button type="submit">회원가입</Button>
      </Form>
    </div>
  );
};

export default CreateUser;
