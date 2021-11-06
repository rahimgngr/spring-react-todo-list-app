import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { FormControl } from "@mui/material";
import { Button } from "@mui/material";
import axios from "axios";

// ADDING CATEGORY
function Form() {
  const [form, setForm] = useState({ title: "" });

  const formSubmit = async () => {
    axios
      .post("http://localhost:8080/todos", JSON.stringify(form), {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((res) => alert("ADDED CATEGORY : " + JSON.stringify(res.data)))
      .then(setForm({ title: "" }));
  };

  const formChange = (e) => {
    setForm({ [e.target.name]: e.target.value });
  };

  return (
    <div>
      <FormControl onSubmit={formSubmit}>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 1, width: "25ch" },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="title"
            label="Add Category"
            variant="outlined"
            name="title"
            values={form.title}
            onChange={formChange}
          />
          <br />
          <Button variant="contained" type="submit">
            Save
          </Button>
        </Box>
      </FormControl>
    </div>
  );
}

export default Form;
