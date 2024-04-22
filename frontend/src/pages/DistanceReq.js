import React, { useState, useEffect } from 'react';
import axios from 'axios';
import address from '../API_KEY'

const DistanceReq = (props) => {

    const [data,setData] = useState([])
    const [loading,setLoading] = useState(true)
    const [error,setError] = useState('')
    const [valueId,setValueId] = useState('')
    const [num,setNum] = useState(0)

    useEffect(()=>{
        axios.post(`${address.backendaddress}/testonelist`, { id: valueId }, {
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
        <div style={{ width: '100%' }}>
            <input width={500} type='text' value={valueId} onChange={evt => setValueId(evt.target.value)}/>
            <button onClick={search}>검색</button>
            <div>
                {loading ? <h4>로딩중...</h4> : (
                    <div>
                        {data.map((item, index) => (
                            <div key={index} style={{ borderWidth: 2, borderStyle: 'solid' }}>
                                <p>아이디: {item.id}</p>
                                <p>주소: {item.address}</p>
                                <p>거리: {item.distance}Km 떨어짐</p>
                            </div>
                        ))}
                    </div>
                )}
            </div>
            <p>{error}</p>
        </div>
    );
    
};

export default DistanceReq;
