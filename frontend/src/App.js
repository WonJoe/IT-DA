import { Container } from "react-bootstrap";
import Header from "./components/Header";
import { Route } from "react-router-dom/cjs/react-router-dom.min";
import List from "./pages/List";
import Write from "./pages/Write";
import Test from "./pages/LocationWrite";
import Listtest from "./pages/ListLocation";
import DistanceReq from "./pages/DistanceReq";

function App() {
  return (
    <div> 
      <Header/>
      <Container>
        <Route path="/" exact component={List}/>
        <Route path="/write" exact component={Write}/>
        <Route path="/test" exact component={Test}/>
        <Route path="/testlist" exact component={Listtest}/>
        <Route path="/distanceReq" exact component={DistanceReq}/>
      </Container>
    </div>
  );
}

export default App;
