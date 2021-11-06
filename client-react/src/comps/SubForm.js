import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { FormControl } from "@mui/material";
import { Button } from "@mui/material";
import axios from "axios";

// ADDING TASK
const initVal = {
  task: "",
  completed: false,
};

function SubForm({ titleId }) {
  const [formVal, setFormVal] = useState(initVal);

  const formValSubmit = async () => {
    await axios
      .post(
        `http://localhost:8080/todos/add/${titleId}`,
        JSON.stringify(formVal),
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((res) => alert(JSON.stringify(res.data.body)));
  };

  const formValChange = (e) => {
    setFormVal({ ...formVal, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <FormControl onSubmit={formValSubmit}>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 1, width: "25ch" },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="task"
            label="Add Task"
            variant="outlined"
            name="task"
            value={formVal.task}
            onChange={formValChange}
          />
          <br />

          <Button variant="contained" type="submit">
            Add Task
          </Button>
        </Box>
      </FormControl>
    </div>
  );
}

export default SubForm;
