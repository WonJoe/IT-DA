import React, { useEffect, useState } from 'react';
import TestItem from '../components/TestItem';
import address from '../API_KEY'

const List = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch(`${address.backendaddress}/testlist`)
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      });
  // }, [posts]);
  }, []);

  return (
    <div>
      {posts.map((post) => (
        <TestItem key={post.userNo} post={post} />
      ))}
    </div>
  );
};

export default List;
