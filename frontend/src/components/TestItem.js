import React from 'react';
import { Card } from 'react-bootstrap';

const PostItem = ({post}) => {

  // 숫자 타임스탬프를 Date 객체로 변환
  const timestamp = new Date(post.createdLocationTime);

  // 변환된 Date 객체를 이용하여 원하는 형식으로 시간을 문자열로 만듦
  const formattedTime = timestamp.toLocaleString();

  return (
    <Card>
      <Card.Body>
        <Card.Title>{post.id}</Card.Title>
        <Card.Text>{post.address}</Card.Text>
        <Card.Text>{formattedTime}</Card.Text>
        <Card.Text>{post.createdLocationTime}</Card.Text>
        <Card.Text>{post.adjustedLat}</Card.Text>
        <Card.Text>{post.adjustedLng}</Card.Text>
        <Card.Text>{post.lat}</Card.Text>
        <Card.Text>{post.lng}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default PostItem;
