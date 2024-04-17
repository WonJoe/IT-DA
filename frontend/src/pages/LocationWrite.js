import React, { useEffect } from 'react';
import './LocationWrite.css';
import api from '../API_KEY';
import mapStyle from '../mapStyle';

const LocationWrite = (props) => {

    let address;
    let lat;
    let lng;
    
    useEffect(() => {

        let map;
        let marker;
        
        let itwillLat = 37.498682;
        let itwillLng = 127.031897;

        function initMap() {

            if (window.google && window.google.maps) {
                map = new window.google.maps.Map(document.getElementById("map"), {
                    center: { lat: itwillLat, lng: itwillLng },
                    zoom: 17,
                    styles: mapStyle.styles
                });
    
                let location = {
                    lat: itwillLat,
                    lng: itwillLng
                };
    
                let firstLocation = new window.google.maps.LatLng(location.lat, location.lng);
                initMapWithLocation(firstLocation);
    
                getLocation();
            }
        }

        function getLocation() {
            let geolocationTimeout;
            
            if (navigator.geolocation) {
                geolocationTimeout = setTimeout(() => {
                    alert("사용자 위치를 가져오는 데 시간이 너무 오래 걸립니다.");
                }, 15000);
                
                navigator.geolocation.getCurrentPosition((position) => {
                    clearTimeout(geolocationTimeout);
                    initMapWithLocation(position);
                }, (error) => {
                    clearTimeout(geolocationTimeout);
                    console.error("사용자 위치를 가져오는데 실패했습니다:", error);
                    alert("사용자 위치를 가져오는 데 실패했습니다.");
                    let position = {
                        coords : {
                            latitude : itwillLat,
                            longitude : itwillLng
                        }
                    }
                    initMapWithLocation(position);
                });
            } else {
                alert("이 브라우저는 내위치 불러오기를 지원하지 않습니다.");
            }
        }

        function initMapWithLocation(position) {
            if (position && position.coords) {
                let location = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
        
                let newLocation = new window.google.maps.LatLng(location.lat, location.lng);
        
                reverseGeocode(newLocation);
                placeMarker(newLocation, map);
            }
        }

        function reverseGeocode(location) {
            const geocoder = new window.google.maps.Geocoder();
            geocoder.geocode({ location: location }, (results, status) => {
                if (status === "OK") {
                    if (results[0]) {
                        for (let i = 0; i < results.length; i++) {
                            if (results[i].types.includes('sublocality_level_2')) {
                                console.log("Sublocality level 2 address: " + results[i].formatted_address);
                                address = results[i].formatted_address;
                                console.log(address)
                                    lat = location.lat()
                                    lng = location.lng()
                                    console.log(lat)
                                    console.log(lng)
                                break;
                            } else {
                                address = '정확한 주소를 선택해 주세요.';
                            }
                        }

                        updateInfo();
                    } else {
                        alert("주소를 찾을 수 없습니다.");
                    }
                } else {
                    alert("지오코딩 요청이 실패했습니다.");
                }
            });
        }


        function placeMarker(location, map) {

            let contentString =
                '<div id="content">' +
                '<div id="siteNotice">' +
                "</div>" +
                '<h3 id="firstHeading" class="firstHeading">이 주소가 맞나요?</h3>' +
                '<div id="bodyContent">' +
                "<p><div id='info'></div></p>" +
                "<p><b>이 주소가 아니라면 지도를 클릭하거나 마커를 드래그 해주세요.</b></p>" +
                '<button id="getLocationButton">내 위치 찾기</button><button id="getTestButton">맞습니다</button>' +
                "</div>" +
                "</div>";

                // const contentElement = document.createElement('div');
                // contentElement.innerHTML = contentString;
                
                // // 버튼 클릭 이벤트 핸들러 추가
                // const getLocationButton = contentElement.querySelector('#getLocationButton');
                // const getTestButton = contentElement.querySelector('#getTestButton');
                
                // getLocationButton.addEventListener('click', () => {
                //     // 내 위치 찾기 버튼이 클릭되었을 때 수행할 작업
                //     getLocation();
                // });
                
                // getTestButton.addEventListener('click', () => {
                //     // 맞습니다 버튼이 클릭되었을 때 수행할 작업
                //     submitPost();
                // });

            let infowindow = new window.google.maps.InfoWindow({
                content: contentString
              });

              infowindow.addListener('domready', () => {
                const getLocationButton = document.getElementById('getLocationButton');
                const getTestButton = document.getElementById('getTestButton');
            
                // 내 위치 찾기 버튼 클릭 이벤트 리스너
                getLocationButton.addEventListener('click', () => {
                    getLocation();
                });
            
                // 맞습니다 버튼 클릭 이벤트 리스너
                getTestButton.addEventListener('click', () => {
                    submitPost();
                });
            });

            if (marker) {
                marker.setMap(null);
            }

            marker = new window.google.maps.Marker({
                position: location,
                map: map,
                draggable: true
            });

            infowindow.open({
                anchor: marker,
                map,
              });

            map.panTo(location);

            map.addListener("click", (event) => {
                marker.setPosition(event.latLng);
                reverseGeocode(event.latLng);
                map.panTo(event.latLng);
            });

            marker.addListener("dragend", (event) => {
                marker.setPosition(event.latLng);
                reverseGeocode(event.latLng);
                map.panTo(event.latLng);
            });
        }

        

        function updateInfo() {
            const info = document.getElementById("info");
            info.innerHTML = address;
        }

        const handleTestButtonClick = () => {
            submitPost()
        };

        

        document.getElementById("getTestButton").addEventListener("click", handleTestButtonClick);

        const script = document.createElement("script");
        script.src = `https://maps.googleapis.com/maps/api/js?key=${api.api}`;
        script.async = true;
        script.defer = true;
        script.onload = initMap;
        document.body.appendChild(script);

        const handleGetLocationButtonClick = () => {
            getLocation();
        };

        document.getElementById("getLocationButton").addEventListener("click", handleGetLocationButtonClick);

        return () => {
            document.body.removeChild(script);
        };
    }, []);

    const submitPost = () => {

        const postData = {
            address: address,
            lat: lat,
            lng: lng
        };

        fetch('http://localhost:8080/test', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json; charset-utf-8',
          },
          body: JSON.stringify(postData),
        })
          .then((res) => res.json())
          .then((res) => console.log(res), props.history.push('/testlist'));
      };

    return (
        <>
            <button id="getLocationButton">내 위치 찾기</button>
            <button id="getTestButton">맞습니다</button>
            <div id="map"></div>
            <div id="info"></div>
        </>
    );
};

export default LocationWrite;
