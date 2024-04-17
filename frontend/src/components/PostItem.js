import React from 'react';
import { Card } from 'react-bootstrap';

const PostItem = ({post}) => {
  return (
    <Card>
      <Card.Body>
        <Card.Title>{post.title}</Card.Title>
        <Card.Text>{post.contents}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default PostItem;
