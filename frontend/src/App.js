import { Container } from "react-bootstrap";
import Header from "./components/Header";
import { Route } from "react-router-dom/cjs/react-router-dom.min";
import DistanceReq from "./pages/DistanceReq";
import CreateUser from "./pages/CreateUser";
import Complete from "./pages/Complete";


function App() {
  return (
    <div> 
      <Header/>
      <Container>
        <Route path="/" exact component={CreateUser}/>
        <Route path="/distanceReq" exact component={DistanceReq}/>
        <Route path="/createUser" exact component={CreateUser}/>
        <Route path="/complete" exact component={Complete}/>
      </Container>
    </div>
  );
}

export default App;
