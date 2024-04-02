import React from 'react'; 
import { Container, Nav, Navbar } from 'react-bootstrap'; 
import { NavLink } from 'react-router-dom'; // NavLink로 변경
 
const Header = () => { 
    return ( 
      <Navbar bg="dark" variant="dark"> 
        <Container> 
          <NavLink to="/" className="navbar-brand">Navbar</NavLink>
          <Nav className="me-auto"> 
            <NavLink to ="/" className="nav-link">홈</NavLink>
            <NavLink to ="/write" className="nav-link">글쓰기</NavLink>
          </Nav> 
        </Container> 
      </Navbar> 
    ); 
}; 
 

export default Header;