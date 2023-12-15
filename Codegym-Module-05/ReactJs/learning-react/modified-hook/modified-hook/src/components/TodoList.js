import {useState} from "react";
import {logDOM} from "@testing-library/react";

function TodoList() {
    const storageJobs = JSON.parse(localStorage.getItem('jobs'))

    const [job, setJob] = useState('');
    const [jobList, setJobList] = useState(storageJobs ?? []);

    const handleSubmit = () => {
        setJobList(prev => {
            const newJobList = [...prev, job];
            const jsonJobList = JSON.stringify(newJobList);
            localStorage.setItem('jobs', jsonJobList);
            return newJobList;
        })
        setJob('')
    }
    return (
        <>
            <div style={{padding: 32}}>
                <input
                    value={job}
                    onChange={e => setJob(e.target.value)}
                />

                <button onClick={handleSubmit}>Add</button>

                <ul>
                    {console.log(jobList)}
                    {jobList.map((job, index) => (
                        <li key={index}>{job}</li>
                    ))}
                </ul>
            </div>
        </>
    )
}

export default TodoList;