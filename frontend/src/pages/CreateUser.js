import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import address from '../API_KEY';

const CreateUser = (props) => {
  const [createData, setCreateData] = useState({
    users: {
      userId: '',
      userPassword: ''
    },
    location: {
      lat: '',
      lng: ''
    }
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    const category = name.split('.')[0]; // users or location
    const field = name.split('.')[1]; // userId, userName, lat, or lng

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

  return (
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
        <Form.Label>위도</Form.Label>
        <Form.Control
          type="text"
          name="location.lat"
          value={createData.location.lat}
          onChange={handleChange}
        />
      </Form.Group>
      <Form.Group className="mb-3">
        <Form.Label>경도</Form.Label>
        <Form.Control
          type="text"
          name="location.lng"
          value={createData.location.lng}
          onChange={handleChange}
        />
      </Form.Group>
      <Button type="submit">회원가입</Button>
    </Form>
  );
};

export default CreateUser;
