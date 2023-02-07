// import logo from './logo.svg';
import { Component } from 'react';
import './App.css'
import LearningComponent from './components/LearningComponent';
function App() {
  return (
    <div className="App">
      <LearningComponent></LearningComponent>
    </div>
  )
}
export default App;
// this is called function componentm ,we also have class component
// function FirstComponent(){
//   return (
//     <div className='FirstComponent'>FirstComponent</div>
//   )
// }
// function SecondComponent(){
//   return (
//     <div className='SecondComponent'>SecondComponent</div>
//   )
// }
// class ThirdComponent extends Component{
  // we need to use html to render a component
//   render(){
//   return (
//   <div className='ThirdComponent'>ThirdComponent</div>
//     )
//   }
// }
// component should have the name with first character upper
// class FourthComponent extends Component{
  // we need to use html to render a component
  // render(){
  // return (
    // only one parent tag is allowed in jsx (javascript xml)
    // we can use <div or <> as parent tag
//   <div className='FourthComponent'>FourthComponent</div>
//     )
//   }
// }
// export default App;
