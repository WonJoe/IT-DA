import { Container } from "react-bootstrap";
import Header from "./components/Header";
import { Route } from "react-router-dom/cjs/react-router-dom.min";
import List from "./pages/List";
import Write from "./pages/Write";
import Test from "./pages/LocationWrite";

function App() {
  return (
    <div> 
      <Header/>
      <Container>
        <Route path="/" exact component={List}/>
        <Route path="/write" exact component={Write}/>
        <Route path="/test" exact component={Test}/>
      </Container>
    </div>
  );
}

export default App;
