import "./App.css";

import Form from "./comps/Form";
import FormList from "./comps/FormList";
import ListTodo from "./comps/ListTodo";

function App() {
  return (
    <div className="App">
      <h1>TODO LIST</h1>
      <Form />
      <FormList />
      <ListTodo />
    </div>
  );
}

export default App;
