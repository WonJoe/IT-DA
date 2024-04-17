import React, { useEffect, useState } from 'react';
import TestItem from '../components/TestItem';

const List = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/testlist')
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      });
  // }, [posts]);
  }, []);

  return (
    <div>
      {posts.map((post) => (
        <TestItem key={post.id} post={post} />
      ))}
    </div>
  );
};

export default List;
