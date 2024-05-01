import { Container } from "react-bootstrap";
import Header from "./components/Header";
import { Route } from "react-router-dom/cjs/react-router-dom.min";
import DistanceReq from "./pages/DistanceReq";
import CreateUser from "./pages/CreateUser";
import Complete from "./pages/Complete";
import Footer from "./components/Footer";
import ConditionsOfUse from "./components/FooterDescription/ConditionsOfUse";
import LocationServicePolicy from "./components/FooterDescription/LocationServicePolicy";
import PrivacyPolicy from "./components/FooterDescription/PrivacyPolicy";
import YouthProtectionPolicy from "./components/FooterDescription/YouthProtectionPolicy";


function App() {
  return (
    <div> 
      <Header/>
      <Container>
        <Route path="/" exact component={CreateUser}/>
        <Route path="/distanceReq" exact component={DistanceReq}/>
        <Route path="/createUser" exact component={CreateUser}/>
        <Route path="/complete" exact component={Complete}/>
        <Route path="/ConditionsOfUse" exact component={ConditionsOfUse}/>
        <Route path="/LocationServicePolicy" exact component={LocationServicePolicy}/>
        <Route path="/PrivacyPolicy" exact component={PrivacyPolicy}/>
        <Route path="/YouthProtectionPolicy" exact component={YouthProtectionPolicy}/>
      </Container>
      <Footer/>
    </div>
  );
}

export default App;
