import React, { useState, useEffect } from 'react';
import axios from 'axios';

const DistanceReq = (props) => {

    const [data,setData] = useState([])
    const [loading,setLoading] = useState(true)
    const [error,setError] = useState('')
    const [valueId,setValueId] = useState('')
    const [num,setNum] = useState(0)

    useEffect(()=>{
        axios.post('http://localhost:8080/testonelist', { id: valueId }, {
    headers: {
      'Content-Type': 'application/json; charset=utf-8',
    },
  })
        .then(res=>{
            console.log(res)
            setData(res.data)
            setLoading(false)
            setError('')
        }).catch(error=>{
            setData({})
            setLoading(true)
            setError('데이터를 찾을 수 없습니다.')
        })
        // axios.request.
    },[num])

    const search = () =>{
        setNum(valueId)
    }

  return (
    <div>
            <input type='text' value={valueId} onChange={evt => setValueId(evt.target.value)}/>
            <button onClick={search}>검색</button>
            <h4>
                {
                    data && loading ? <h2>로딩중...</h2>
                    :
                        
                        <div>
                            {data.map((item, index) => (
                                <div key={index}  style={{borderWidth: 2, borderStyle: 'solid'}}>
                                    아이디 : {item.id}<br/>
                                    주소 : {item.address}<br/>
                                    거리 : {item.distance}Km 떨어짐<br/>
                                </div>
                            ))}
                        </div>

                }
                <p>
                    {error ? error : null}
                </p>
            </h4>
        </div>
  );
};

export default DistanceReq;
