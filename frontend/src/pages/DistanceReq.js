import React, { useState, useEffect } from 'react';
import axios from 'axios';
import address from '../API_KEY';
import { Button, Form } from 'react-bootstrap';


const DistanceReq = (props) => {

    const [data,setData] = useState([])
    const [loading,setLoading] = useState(true)
    const [error,setError] = useState('')
    const [valueId,setValueId] = useState('')
    const [num,setNum] = useState(0)

    useEffect(()=>{
        if (valueId === null || valueId === '') {
            return;
        }
        axios.post(`${address.backendaddress}/testonelist`, { userNo: valueId }, {
            headers: {
            'Content-Type': 'application/json; charset=utf-8',
            },
        })
        .then(res=>{
            console.log(res)
            console.log(res.data)
            setData(res.data)
            setLoading(false)
            setError('')
        }).catch(error=>{
            setData({})
            setLoading(true)
            setError('데이터를 찾을 수 없습니다.')
        })
    },[num])

    const search = () =>{
        setNum(valueId)
    }

    return (
        <div style={{ width: '100%' }}>
            <Form.Label>UserNo</Form.Label>
            <Form.Control
                type="text"
                name="users.userId"
                value={valueId}
                onChange={evt => setValueId(evt.target.value)}
            />
            {/* <input width={500} type='text' value={valueId} onChange={evt => setValueId(evt.target.value)}/> */}
            <Button onClick={search}>검색</Button>
            <div>
                {loading ? <h4>로딩중...</h4> : (
                    <div>
                        {data && data.length > 0 ? (
                            data.map((item, index) => (
                                <div key={index} style={{ borderWidth: 2, borderStyle: 'solid' }}>
                                    <p>userNo: {item.userNo}</p>
                                    <p>주소: {item.address.split(' ').filter((part, index) => index !== 0 && index !==  item.address.split(' ').length - 1).join(' ')}</p>
                                    <p>거리: {item.distance}Km 떨어짐</p>
                                    <p>아이디: {item.user_id}</p>
                                </div>
                            ))
                        ) : (
                            <p>더 이상 요청할 수 없습니다.</p>
                        )}
                    </div>
                )}
            </div>
            <p>{error}</p>
        </div>
    );
    
};

export default DistanceReq;
