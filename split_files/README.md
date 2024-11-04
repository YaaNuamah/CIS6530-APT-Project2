# CIS6530-APT-Project2

## Repository Structure
This repository contains split files for APT analysis submission. Due to size limitations, large files have been split into manageable chunks using Git LFS.

### Directory Structure
```
.
├── split_files/
│   ├── assignment_part_*   # Split file chunks
│   ├── reassemble.sh       # Script to reassemble the files
│   └── original_checksum.txt  # Verification checksum
```

## Setup Instructions

1. Clone the repository with Git LFS:
# Install Git LFS
sudo apt update
sudo apt install git-lfs

# Clone the repository
git clone https://github.com/YaaNuamah/CIS6530-APT-Project2.git
cd CIS6530-APT-Project2

# Initialize Git LFS
git lfs install

2. Reassemble the files:

cd split_files
./reassemble.sh

## File Verification
- The original file checksum is stored in `original_checksum.txt`
- The reassembly script automatically verifies the checksum
- If you get a success message, the file has been correctly reassembled

## Notes
- The reassembled file will be named `submission3.zip`
- Make sure you have enough disk space for the reassembled file
- All split files must be present for successful reassembly

## Troubleshooting
If you encounter issues:
1. Ensure Git LFS is properly installed
2. Verify all split files were downloaded
3. Check available disk space
4. Ensure execute permissions on reassemble.sh (`chmod +x reassemble.sh`)

EOF
