import { useState, useEffect } from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import axios from "axios";
import SubForm from "./SubForm";

// CATEGORY DROPDOWN
function FormList() {
  const [categories, setCategories] = useState([]);
  const [id, setId] = useState("");

  useEffect(() => {
    async function getTodos() {
      await axios
        .get("http://localhost:8080/todos")
        .then((res) => setCategories(res.data));
    }
    getTodos();
  }, []);

  const handleChange = async (e) => {
    setId(e.target.value);
  };

  return (
    <div>
      <FormControl>
        <InputLabel id="categoryId">Choose Category..</InputLabel>

        <Select
          style={{ width: "25ch" }}
          labelId="categoryLabel"
          id="categoryLabelId"
          label="Category"
          onChange={handleChange}
          options={categories}
          defaultValue=""
        >
          {categories.map((category) => (
            <MenuItem key={category.titleId} value={category.titleId}>
              {category.title}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      <SubForm titleId={id} />
    </div>
  );
}

export default FormList;
