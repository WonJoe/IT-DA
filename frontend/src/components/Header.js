import React from 'react'; 
import { Container, Nav, Navbar } from 'react-bootstrap'; 
import { Link } from 'react-router-dom'; 
 
const Header = () => { 
    return ( 
      <Navbar bg="dark" variant="dark"> 
        <Container> 
          <Link to="/" className="navbar-brand">Navbar</Link> 
          <Nav className="me-auto"> 
            <Link to ="/" className="nav-link">홈</Link>|
            <Link to ="/distanceReq" className="nav-link">거리순 매칭</Link>
            <Link to ="/createUser" className="nav-link">회원가입</Link>
          </Nav> 
        </Container> 
      </Navbar> 
    ); 
}; 
 
export default Header;