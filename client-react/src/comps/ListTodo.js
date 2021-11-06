import React, { useState, useMemo } from "react";
import axios from "axios";

// LISTING TASKS
function ListTodo() {
  const [data, setData] = useState([]);
  const [count, setCount] = useState(0);

  async function getData() {
    await axios
      .get("http://localhost:8080/todos")
      .then((res) => setData(res.data));
  }

  async function deleteToggle(id) {
    await axios.delete(`http://localhost:8080/todos/task/${id}`);
    setCount(count + 1);
  }

  useMemo(() => {
    getData();
  }, [count]);

  const toggleIsCompleted = (id, completed) => {
    putData({ id, data: { completed } });
  };

  const putData = async ({ id, data }) => {
    const res = await axios.put(`http://localhost:8080/todos/task/${id}`, data);
    setCount(count + 1);
    return res.data;
  };

  return (
    <div>
      {data.map((i) => (
        <div key={i.titleId}>
          {i.todoSubEntities.map((item) => (
            <ul style={{ listStyleType: "none" }}>
              <li key={item.taskId}>
                <input
                  type="checkbox"
                  checked={item.completed}
                  onChange={() =>
                    toggleIsCompleted(item.taskId, !item.completed)
                  }
                />
                {item.completed ? (
                  <strike>{i.title + " *** " + item.task}</strike>
                ) : (
                  i.title + " *** " + item.task
                )}
                <button
                  onClick={() => deleteToggle(item.taskId)}
                  style={{ marginLeft: "10px" }}
                >
                  DELETE
                </button>
              </li>
            </ul>
          ))}
        </div>
      ))}
    </div>
  );
}

export default ListTodo;
