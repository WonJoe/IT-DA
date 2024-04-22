import React, { useEffect, useState } from 'react';
import PostItem from '../components/PostItem';
import address from '../API_KEY'

const List = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch(`${address.backendaddress}/post`)
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      });
  // }, [posts]);
  }, []);

  return (
    <div>
      {posts.map((post) => (
        <PostItem key={post.id} post={post} />
      ))}
    </div>
  );
};

export default List;
